package LeetCode.everyDay;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 在线库存查询结果
 * @author: wenjie.li
 */
public class OnlineSyncStockResult implements Serializable {
    private static final long serialVersionUID = -9042970097839909672L;
    //skuId 商品编码
    private Long skuId;
    //可售库存数量EA品为数量，非EA品为重量 单位g
    private BigDecimal stock;
    //物料码
    private String rfId;
    //门店id
    private Integer storeId;
    //商家门店编码
    private String sapStoreId;
    //库存变化版本号
    private Long version;
    //多点商家id
    private Long vendorId;
    //商家商家编码
    private String sapVendorId;
    //真实预占库存(单位：库存基本单位)
    private BigDecimal realOccupyStock;
    public BigDecimal getRealOccupyStock() {
        return realOccupyStock;
    }
    public void setRealOccupyStock(BigDecimal realOccupyStock) {
        this.realOccupyStock = realOccupyStock;
    }
    public Long getSkuId() {
        return skuId;
    }
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    public BigDecimal getStock() {
        return stock;
    }
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
    public String getRfId() {
        return rfId;
    }
    public void setRfId(String rfId) {
        this.rfId = rfId;
    }
    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public String getSapStoreId() {
        return sapStoreId;
    }
    public void setSapStoreId(String sapStoreId) {
        this.sapStoreId = sapStoreId;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public Long getVendorId() {
        return vendorId;
    }
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
    public String getSapVendorId() {
        return sapVendorId;
    }
    public void setSapVendorId(String sapVendorId) {
        this.sapVendorId = sapVendorId;
    }
}
