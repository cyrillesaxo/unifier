package io.swagger.model;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * BillingChargesCredits
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Table(table = "charges_credits")
public class ChargesCredits {

	@Column("customer_id")
	@PartitionKey
	@JsonProperty("customer_id")
	private String customerId = null;

	@Column("charge_origin")
	@JsonProperty("charge_origin")
	private String chargeOrigin = null;

	@Column("cycle_code")
	@ClusteringColumn(2)
	@JsonProperty("cycle_code")
	private String cycleCode = null;

	@Column("mdn")
	@ClusteringColumn(1)
	@JsonProperty("mdn")
	private String mdn = null;

	@Column("charge_type")
	@JsonProperty("charge_type")
	private String chargeType = null;

	@Column("charge_code")
	@JsonProperty("charge_code")
	private String chargeCode = null;

	@Column("amount")
	@JsonProperty("amount")
	private String amount = null;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public ChargesCredits chargeOrigin(String chargeOrigin) {
		this.chargeOrigin = chargeOrigin;
		return this;
	}

	/**
	 * Get chargeOrigin
	 * 
	 * @return chargeOrigin
	 **/
	@ApiModelProperty(value = "")

	public String getChargeOrigin() {
		return chargeOrigin;
	}

	public void setChargeOrigin(String chargeOrigin) {
		this.chargeOrigin = chargeOrigin;
	}

	public ChargesCredits cycleCode(String cycleCode) {
		this.cycleCode = cycleCode;
		return this;
	}

	/**
	 * Get cycleCode
	 * 
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

	public ChargesCredits mdn(String mdn) {
		this.mdn = mdn;
		return this;
	}

	/**
	 * Get mdn
	 * 
	 * @return mdn
	 **/
	@ApiModelProperty(value = "")

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public ChargesCredits chargeType(String chargeType) {
		this.chargeType = chargeType;
		return this;
	}

	/**
	 * Get chargeType
	 * 
	 * @return chargeType
	 **/
	@ApiModelProperty(value = "")

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public ChargesCredits chargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
		return this;
	}

	/**
	 * Get chargeCode
	 * 
	 * @return chargeCode
	 **/
	@ApiModelProperty(value = "")

	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public ChargesCredits amount(String amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Get amount
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargesCredits other = (ChargesCredits) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (chargeCode == null) {
			if (other.chargeCode != null)
				return false;
		} else if (!chargeCode.equals(other.chargeCode))
			return false;
		if (chargeOrigin == null) {
			if (other.chargeOrigin != null)
				return false;
		} else if (!chargeOrigin.equals(other.chargeOrigin))
			return false;
		if (chargeType == null) {
			if (other.chargeType != null)
				return false;
		} else if (!chargeType.equals(other.chargeType))
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
		if (mdn == null) {
			if (other.mdn != null)
				return false;
		} else if (!mdn.equals(other.mdn))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((chargeCode == null) ? 0 : chargeCode.hashCode());
		result = prime * result + ((chargeOrigin == null) ? 0 : chargeOrigin.hashCode());
		result = prime * result + ((chargeType == null) ? 0 : chargeType.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((cycleCode == null) ? 0 : cycleCode.hashCode());
		result = prime * result + ((mdn == null) ? 0 : mdn.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ChargesCredits [customerId=" + customerId + ", chargeOrigin=" + chargeOrigin + ", cycleCode="
				+ cycleCode + ", mdn=" + mdn + ", chargeType=" + chargeType + ", chargeCode=" + chargeCode + ", amount="
				+ amount + "]";
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
