package com.inspirecoding.mlchallenge.data.remote.mapper

import com.inspirecoding.mlchallenge.data.remote.model.attribute.AttributeResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablefilter.AvailableFilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablesort.AvailableSortResponse
import com.inspirecoding.mlchallenge.data.remote.model.conditions.ConditionsResponse
import com.inspirecoding.mlchallenge.data.remote.model.differentialpricing.DifferentialPricingResponse
import com.inspirecoding.mlchallenge.data.remote.model.filter.FilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.installments.InstallmentsResponse
import com.inspirecoding.mlchallenge.data.remote.model.metadata.MetadataResponse
import com.inspirecoding.mlchallenge.data.remote.model.paging.PagingResponse
import com.inspirecoding.mlchallenge.data.remote.model.path.PathFromRootResponse
import com.inspirecoding.mlchallenge.data.remote.model.pdp.PdpTrackingResponse
import com.inspirecoding.mlchallenge.data.remote.model.product.ProductInfoResponse
import com.inspirecoding.mlchallenge.data.remote.model.product.ProductsResponse
import com.inspirecoding.mlchallenge.data.remote.model.result.ResultResponse
import com.inspirecoding.mlchallenge.data.remote.model.saleprice.SalePriceResponse
import com.inspirecoding.mlchallenge.data.remote.model.seller.SellerResponse
import com.inspirecoding.mlchallenge.data.remote.model.shipping.ShippingResponse
import com.inspirecoding.mlchallenge.data.remote.model.sort.SortResponse
import com.inspirecoding.mlchallenge.data.remote.model.struct.StructResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueStructResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXXResponse
import com.inspirecoding.mlchallenge.domain.model.attribute.AttributeDomain
import com.inspirecoding.mlchallenge.domain.model.availablefilter.AvailableFilterDomain
import com.inspirecoding.mlchallenge.domain.model.availablesort.AvailableSortDomain
import com.inspirecoding.mlchallenge.domain.model.conditions.ConditionsDomain
import com.inspirecoding.mlchallenge.domain.model.differentialpricing.DifferentialPricingDomain
import com.inspirecoding.mlchallenge.domain.model.filter.FilterDomain
import com.inspirecoding.mlchallenge.domain.model.installments.InstallmentsDomain
import com.inspirecoding.mlchallenge.domain.model.metadata.MetadataDomain
import com.inspirecoding.mlchallenge.domain.model.paging.PagingDomain
import com.inspirecoding.mlchallenge.domain.model.path.PathFromRootDomain
import com.inspirecoding.mlchallenge.domain.model.pdp.PdpTrackingDomain
import com.inspirecoding.mlchallenge.domain.model.product.ProductInfoDomain
import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.domain.model.saleprice.SalePriceDomain
import com.inspirecoding.mlchallenge.domain.model.seller.SellerDomain
import com.inspirecoding.mlchallenge.domain.model.shipping.ShippingDomain
import com.inspirecoding.mlchallenge.domain.model.sort.SortDomain
import com.inspirecoding.mlchallenge.domain.model.struct.StructDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueStructDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueXDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueXXDomain

internal fun AttributeResponse.toDomain() = AttributeDomain(
    attributeGroupId = this.attributeGroupId,
    attributeGroupName = this.attributeGroupName,
    id = this.id,
    name = this.name,
    source = this.source,
    valueId = this.valueId,
    valueName = this.valueName,
    valueStruct = this.valueStruct?.toDomain(),
    valueType = this.valueType,
    values = this.values?.map { it.toDomain() }
)

internal fun AvailableFilterResponse.toDomain() = AvailableFilterDomain(
    id = this.id,
    name = this.name,
    type = this.type,
    valueResponses = this.valueResponses?.map { it.toDomain() }
)

internal fun AvailableSortResponse.toDomain() = AvailableSortDomain(
    id = this.id,
    name = this.name
)

internal fun ConditionsResponse.toDomain() = ConditionsDomain(
    contextRestrictions = this.contextRestrictions,
    eligible = this.eligible,
    endTime = this.endTime,
    startTime = this.startTime
)

internal fun DifferentialPricingResponse.toDomain() = DifferentialPricingDomain(
    id = this.id
)

internal fun FilterResponse.toDomain() = FilterDomain(
    id = this.id,
    name = this.name,
    type = this.type,
    values = this.values?.map { it.toDomain() }
)

internal fun InstallmentsResponse.toDomain() = InstallmentsDomain(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)

internal fun MetadataResponse.toDomain() = MetadataDomain(
    campaignDiscountPercentage = this.campaignDiscountPercentage,
    campaignEndDate = this.campaignEndDate,
    campaignId = this.campaignId,
    discountAmount = this.discountAmount,
    experimentId = this.experimentId,
    fundingMode = this.fundingMode,
    orderItemPrice = this.orderItemPrice,
    promotionId = this.promotionId,
    promotionType = this.promotionType,
    variation = this.variation
)

internal fun PagingResponse.toDomain() = PagingDomain(
    limit = this.limit,
    offset = this.offset,
    primaryResults = this.primaryResults,
    total = this.total
)

internal fun PathFromRootResponse.toDomain() = PathFromRootDomain(
    id = this.id,
    name = this.name
)

internal fun PdpTrackingResponse.toDomain() = PdpTrackingDomain(
    group = this.group,
    productInfo = this.productInfo?.map { it.toDomain() }
)

internal fun ProductInfoResponse.toDomain() = ProductInfoDomain(
    id = this.id,
    score = this.score,
    status = this.status
)

internal fun ProductsResponse.toDomain() = ProductsDomain(
    availableFilters = this.availableFilters?.map { it.toDomain() },
    availableSorts = this.availableSorts?.map { it.toDomain() },
    countryDefaultTimeZone = this.countryDefaultTimeZone,
    filterResponses = this.filterResponses?.map { it.toDomain() },
    pagingDomain = this.pagingResponse?.toDomain(),
    pdpTracking = this.pdpTracking?.toDomain(),
    resultResponses = this.resultResponses?.map { it.toDomain() },
    siteId = this.siteId,
    sortResponse = this.sortResponse?.toDomain(),
    userContext = this.userContext
)

internal fun SalePriceResponse.toDomain() = SalePriceDomain(
    amount = this.amount,
    conditionsDomain = this.conditionsResponse?.toDomain(),
    currencyId = this.currencyId,
    exchangeRate = this.exchangeRate,
    metadataDomain = this.metadataResponse?.toDomain(),
    paymentMethodPrices = this.paymentMethodPrices,
    paymentMethodType = this.paymentMethodType,
    priceId = this.priceId,
    regularAmount = this.regularAmount,
    type = this.type
)

internal fun SellerResponse.toDomain() = SellerDomain(
    id = this.id,
    nickname = this.nickname
)

internal fun ShippingResponse.toDomain() = ShippingDomain(
    benefits = this.benefits,
    freeShipping = this.freeShipping,
    logisticType = this.logisticType,
    mode = this.mode,
    promise = this.promise,
    shippingScore = this.shippingScore,
    storePickUp = this.storePickUp,
    tags = this.tags
)

internal fun SortResponse.toDomain() = SortDomain(
    id = this.id,
    name = this.name
)

internal fun StructResponse.toDomain() = StructDomain(
    number = this.number,
    unit = this.unit
)

internal fun ValueResponse.toDomain() = ValueDomain(
    id = this.id,
    name = this.name,
    results = this.results
)

internal fun ValueStructResponse.toDomain() = ValueStructDomain(
    number = this.number,
    unit = this.unit
)

internal fun ValueXResponse.toDomain() = ValueXDomain(
    id = this.id,
    name = this.name,
    pathFromRoot = this.pathFromRoot?.map { it.toDomain() }
)

internal fun ValueXXResponse.toDomain() = ValueXXDomain(
    id = this.id,
    name = this.name,
    source = this.source,
    structDomain = this.structResponse?.toDomain()
)

internal fun ResultResponse.toDomain() = ResultDomain(
    acceptsMercadoPago = this.acceptsMercadoPago,
    attributeResponses = this.attributeResponses?.map { it.toDomain() },
    availableQuantity = this.availableQuantity,
    buyingMode = this.buyingMode,
    catalogListing = this.catalogListing,
    catalogProductId = this.catalogProductId,
    categoryId = this.categoryId,
    condition = this.condition,
    currencyId = this.currencyId,
    differentialPricing = this.differentialPricing?.toDomain(),
    discounts = this.discounts,
    domainId = this.domainId,
    id = this.id,
    installmentsDomain = this.installmentsResponse?.toDomain(),
    inventoryId = this.inventoryId,
    listingTypeId = this.listingTypeId,
    officialStoreId = this.officialStoreId,
    officialStoreName = this.officialStoreName,
    orderBackend = this.orderBackend,
    originalPrice = this.originalPrice,
    permalink = this.permalink,
    price = this.price,
    promotions = this.promotions,
    salePrice = this.salePrice?.toDomain(),
    sanitizedTitle = this.sanitizedTitle,
    sellerDomain = this.sellerResponse?.toDomain(),
    shippingDomain = this.shippingResponse?.toDomain(),
    siteId = this.siteId,
    stopTime = this.stopTime,
    thumbnail = this.thumbnail,
    thumbnailId = this.thumbnailId,
    title = this.title,
    useThumbnailId = this.useThumbnailId,
    winnerItemId = this.winnerItemId
)