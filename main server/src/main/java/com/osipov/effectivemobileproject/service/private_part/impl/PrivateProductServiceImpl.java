package com.osipov.effectivemobileproject.service.private_part.impl;

import com.osipov.effectivemobileproject.constants.Constants;
import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.enums.AccountStatus;
import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.error.ConflictException;
import com.osipov.effectivemobileproject.error.NotFoundException;
import com.osipov.effectivemobileproject.mapper.ProductMapper;
import com.osipov.effectivemobileproject.model.Organization;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.model.User;
import com.osipov.effectivemobileproject.repository.ProductRepository;
import com.osipov.effectivemobileproject.service.private_part.PrivateHistoryService;
import com.osipov.effectivemobileproject.service.private_part.PrivateOrganizationService;
import com.osipov.effectivemobileproject.service.private_part.PrivateProductService;
import com.osipov.effectivemobileproject.service.private_part.PrivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.*;

@Service
@Transactional
public class PrivateProductServiceImpl implements PrivateProductService {

    private final ProductRepository productRepository;
    private final PrivateUserService userService;
    private final PrivateOrganizationService companyService;
    private final PrivateHistoryService historyService;

    @Autowired
    public PrivateProductServiceImpl(
            ProductRepository productRepository,
            PrivateUserService userService,
            PrivateOrganizationService companyService,
            PrivateHistoryService historyService
    ) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.companyService = companyService;
        this.historyService = historyService;
    }

    @Override
    public ProductOutDto buyProduct(final Long userId, final Long productId) {
        User user = userService.getUser(userId);
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new NotFoundException(PRODUCT_NOT_FOUND.getTitle()));
        if (user.getBalance() < product.getPrice() || product.getQuantity() <= 0 ||
                Objects.equals(product.getOrganization().getCreator().getId(), user.getId())) {
            throw new ConflictException(PURCHASE_ERROR.getTitle());
        }
        user.setBalance(user.getBalance() - product.getPrice());
        product.setQuantity(product.getQuantity() - Constants.DECREASE);
        Double balanceCreator = product.getOrganization().getCreator().getBalance();
        product.getOrganization().getCreator().setBalance(revenue(product.getPrice(), balanceCreator));
        historyService.savePurchase(user, product);
        return ProductMapper.productToOutDto(product);
    }

    @Override
    public ProductOutDto createProduct(final Long userId, final Long companyId, final ProductInDto productInDto) {
        User user = userService.getUser(userId);
        Organization organization = companyService.getCompany(companyId);
        if (!organization.getCreator().getId().equals(userId) || !user.getAccountStatus().equals(AccountStatus.ACTIVE) ||
                !organization.getOrganizationStatus().equals(OrganizationStatus.ACTIVE)) {
            throw new ConflictException(PRODUCT_CREATION_ERROR.getTitle());
        }
        productInDto.setOrganization(organization);
        return ProductMapper.productToOutDto(
                productRepository.save(ProductMapper.inDtoToProduct(productInDto)));
    }

    @Override
    public ProductOutDto getProduct(final Long productId) {
        return ProductMapper.productToOutDto(productRepository.findByIdAndProductStatusAndOrganization_OrganizationStatus(productId,
                ProductStatus.ACTIVE, OrganizationStatus.ACTIVE));
    }

    @Override
    public List<ProductOutDto> getProducts(final int from, final int size) {
        return ProductMapper.productToListOutDto(productRepository.findAllByProductStatusAndOrganization_OrganizationStatus(
                ProductStatus.ACTIVE, OrganizationStatus.ACTIVE, PageRequest.of(from, size)));
    }

    @Override
    public List<Product> getProductsIn(Collection<Long> productIds) {
        return productRepository.findAllByIdIn(productIds);
    }

    private Double revenue(final Double price, final Double balanceCreator) {
        return balanceCreator + (price - (price * Constants.COMMISSION));
    }
}