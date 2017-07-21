package io.swagger.model;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * BillingAllowances
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Table(table="Allowances")
public class Allowances   {

  @Column("customer_id")
  @PartitionKey
  @JsonProperty("customer_id")
  private String customerId = null;
	  
  @Column("cycle_code")	
  @ClusteringColumn(2)
  @JsonProperty("cycle_code")
  private String cycleCode = null;

  @Column("start_date")
  @JsonProperty("start_date")
  private String startDate = null;

  @Column("end_start")
  @JsonProperty("end_start")
  private String endStart = null;

  @Column("offer_name")
  @JsonProperty("offer_name")
  private String offerName = null;

  @Column("mdn")
  @ClusteringColumn(1)
  @JsonProperty("mdn")
  private String mdn = null;

  @Column("allowance")
  @JsonProperty("allowance")
  private String allowance = null;

  @Column("used")
  @JsonProperty("used")
  private String used = null;

  @Column("remaining")
  @JsonProperty("remaining")
  private String remaining = null;

  @Column("overage")
  @JsonProperty("overage")
  private String overage = null;

  @Column("units")
  @JsonProperty("units")
  private String units = null;

  public Allowances cycleCode(String cycleCode) {
    this.cycleCode = cycleCode;
    return this;
  }

   public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

/**
   * Get cycleCode
   * @return cycleCode
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getCycleCode() {
    return cycleCode;
  }

  public void setCycleCode(String cycleCode) {
    this.cycleCode = cycleCode;
  }

  public Allowances startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public Allowances endStart(String endStart) {
    this.endStart = endStart;
    return this;
  }

   /**
   * Get endStart
   * @return endStart
  **/
  @ApiModelProperty(value = "")


  public String getEndStart() {
    return endStart;
  }

  public void setEndStart(String endStart) {
    this.endStart = endStart;
  }

  public Allowances offerName(String offerName) {
    this.offerName = offerName;
    return this;
  }

   /**
   * Get offerName
   * @return offerName
  **/
  @ApiModelProperty(value = "")


  public String getOfferName() {
    return offerName;
  }

  public void setOfferName(String offerName) {
    this.offerName = offerName;
  }

  public Allowances mdn(String mdn) {
    this.mdn = mdn;
    return this;
  }

   /**
   * Get mdn
   * @return mdn
  **/
  @ApiModelProperty(value = "")


  public String getMdn() {
    return mdn;
  }

  public void setMdn(String mdn) {
    this.mdn = mdn;
  }

  public Allowances allowance(String allowance) {
    this.allowance = allowance;
    return this;
  }

   /**
   * Get allowance
   * @return allowance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getAllowance() {
    return allowance;
  }

  public void setAllowance(String allowance) {
    this.allowance = allowance;
  }

  public Allowances used(String used) {
    this.used = used;
    return this;
  }

   /**
   * Get used
   * @return used
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getUsed() {
    return used;
  }

  public void setUsed(String used) {
    this.used = used;
  }

  public Allowances remaining(String remaining) {
    this.remaining = remaining;
    return this;
  }

   /**
   * Get remaining
   * @return remaining
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getRemaining() {
    return remaining;
  }

  public void setRemaining(String remaining) {
    this.remaining = remaining;
  }

  public Allowances overage(String overage) {
    this.overage = overage;
    return this;
  }

   /**
   * Get overage
   * @return overage
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getOverage() {
    return overage;
  }

  public void setOverage(String overage) {
    this.overage = overage;
  }

  public Allowances units(String units) {
    this.units = units;
    return this;
  }

   /**
   * Get units
   * @return units
  **/
  @ApiModelProperty(value = "")


  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }


  @Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Allowances other = (Allowances) obj;
	if (allowance == null) {
		if (other.allowance != null)
			return false;
	} else if (!allowance.equals(other.allowance))
		return false;
	if (customerId == null) {
		if (other.customerId != null)
			return false;
	} else if (!customerId.equals(other.customerId))
		return false;
	if (cycleCode == null) {
		if (other.cycleCode != null)
			return false;
	} else if (!cycleCode.equals(other.cycleCode))
		return false;
	if (endStart == null) {
		if (other.endStart != null)
			return false;
	} else if (!endStart.equals(other.endStart))
		return false;
	if (mdn == null) {
		if (other.mdn != null)
			return false;
	} else if (!mdn.equals(other.mdn))
		return false;
	if (offerName == null) {
		if (other.offerName != null)
			return false;
	} else if (!offerName.equals(other.offerName))
		return false;
	if (overage == null) {
		if (other.overage != null)
			return false;
	} else if (!overage.equals(other.overage))
		return false;
	if (remaining == null) {
		if (other.remaining != null)
			return false;
	} else if (!remaining.equals(other.remaining))
		return false;
	if (startDate == null) {
		if (other.startDate != null)
			return false;
	} else if (!startDate.equals(other.startDate))
		return false;
	if (units == null) {
		if (other.units != null)
			return false;
	} else if (!units.equals(other.units))
		return false;
	if (used == null) {
		if (other.used != null)
			return false;
	} else if (!used.equals(other.used))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((allowance == null) ? 0 : allowance.hashCode());
	result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
	result = prime * result + ((cycleCode == null) ? 0 : cycleCode.hashCode());
	result = prime * result + ((endStart == null) ? 0 : endStart.hashCode());
	result = prime * result + ((mdn == null) ? 0 : mdn.hashCode());
	result = prime * result + ((offerName == null) ? 0 : offerName.hashCode());
	result = prime * result + ((overage == null) ? 0 : overage.hashCode());
	result = prime * result + ((remaining == null) ? 0 : remaining.hashCode());
	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
	result = prime * result + ((units == null) ? 0 : units.hashCode());
	result = prime * result + ((used == null) ? 0 : used.hashCode());
	return result;
}

  @Override
public String toString() {
	return "Allowances [customerId=" + customerId + ", cycleCode=" + cycleCode + ", startDate=" + startDate
			+ ", endStart=" + endStart + ", offerName=" + offerName + ", mdn=" + mdn + ", allowance=" + allowance
			+ ", used=" + used + ", remaining=" + remaining + ", overage=" + overage + ", units=" + units + "]";
}

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

