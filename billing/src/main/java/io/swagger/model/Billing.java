package io.swagger.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * Billing
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Table(table = "Billing")
public class Billing {

	@Column("customer_id")
	@PartitionKey
	@JsonProperty("customer_id")
	private String customerId = null;

	@Column("number_of_billing")
	@ClusteringColumn(1)
	@JsonProperty("number_of_billing")
	private long numberOfBilling;

	@Column("date")
	@ClusteringColumn(2)
	@JsonProperty("date")
	private String date;

	// @Column("billing_info")
	@JsonProperty("billing_info")
	private BillingInfo billingInfo = null;

	// @Column("last_payment")
	@JsonProperty("last_payment")
	private List<LastPayment> lastPayment = new ArrayList<LastPayment>();

	// @Column("allowances")
	@JsonProperty("allowances")
	private List<Allowances> allowances = new ArrayList<Allowances>();

	// @Column("usage")
	@JsonProperty("usage")
	private List<Usage> usage = new ArrayList<Usage>();

	// @Column("charges_credits")
	@JsonProperty("charges_credits")
	private List<ChargesCredits> chargesCredits = new ArrayList<ChargesCredits>();

	public Billing customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	/**
	 * Get customerId
	 * 
	 * @return customerId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Billing billingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
		return this;
	}

	/**
	 * Get billingInfo
	 * 
	 * @return billingInfo
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}

	public Billing lastPayment(List<LastPayment> lastPayment) {
		this.lastPayment = lastPayment;
		return this;
	}

	public Billing addLastPaymentItem(LastPayment lastPaymentItem) {
		this.lastPayment.add(lastPaymentItem);
		return this;
	}

	
	/**
	 * Get lastPayment
	 * 
	 * @return lastPayment
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public List<LastPayment> getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(List<LastPayment> lastPayment) {
		this.lastPayment = lastPayment;
	}

	public Billing allowances(List<Allowances> allowances) {
		this.allowances = allowances;
		return this;
	}

	public Billing addAllowancesItem(Allowances allowancesItem) {
		this.allowances.add(allowancesItem);
		return this;
	}

	public long getNumberOfBilling() {
		return numberOfBilling;
	}

	public void setNumberOfBilling(long numberOfBilling) {
		this.numberOfBilling = numberOfBilling;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get allowances
	 * 
	 * @return allowances
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public List<Allowances> getAllowances() {
		return allowances;
	}

	public void setAllowances(List<Allowances> allowances) {
		this.allowances = allowances;
	}

	public Billing usage(List<Usage> usage) {
		this.usage = usage;
		return this;
	}

	public Billing addUsageItem(Usage usageItem) {
		this.usage.add(usageItem);
		return this;
	}

	/**
	 * Get usage
	 * 
	 * @return usage
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public List<Usage> getUsage() {
		return usage;
	}

	public void setUsage(List<Usage> usage) {
		this.usage = usage;
	}

	public Billing chargesCredits(List<ChargesCredits> chargesCredits) {
		this.chargesCredits = chargesCredits;
		return this;
	}

	public Billing addChargesCreditsItem(ChargesCredits chargesCreditsItem) {
		this.chargesCredits.add(chargesCreditsItem);
		return this;
	}

	/**
	 * Get chargesCredits
	 * 
	 * @return chargesCredits
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public List<ChargesCredits> getChargesCredits() {
		return chargesCredits;
	}

	public void setChargesCredits(List<ChargesCredits> chargesCredits) {
		this.chargesCredits = chargesCredits;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billing other = (Billing) obj;
		if (allowances == null) {
			if (other.allowances != null)
				return false;
		} else if (!allowances.equals(other.allowances))
			return false;
		if (billingInfo == null) {
			if (other.billingInfo != null)
				return false;
		} else if (!billingInfo.equals(other.billingInfo))
			return false;
		if (chargesCredits == null) {
			if (other.chargesCredits != null)
				return false;
		} else if (!chargesCredits.equals(other.chargesCredits))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (lastPayment == null) {
			if (other.lastPayment != null)
				return false;
		} else if (!lastPayment.equals(other.lastPayment))
			return false;
		if (numberOfBilling != other.numberOfBilling)
			return false;
		if (usage == null) {
			if (other.usage != null)
				return false;
		} else if (!usage.equals(other.usage))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allowances == null) ? 0 : allowances.hashCode());
		result = prime * result + ((billingInfo == null) ? 0 : billingInfo.hashCode());
		result = prime * result + ((chargesCredits == null) ? 0 : chargesCredits.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((lastPayment == null) ? 0 : lastPayment.hashCode());
		result = prime * result + (int) (numberOfBilling ^ (numberOfBilling >>> 32));
		result = prime * result + ((usage == null) ? 0 : usage.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Billing [customerId=" + customerId + ", numberOfBilling=" + numberOfBilling + ", date=" + date
				+ ", billingInfo=" + billingInfo + ", lastPayment=" + lastPayment + ", allowances=" + allowances
				+ ", usage=" + usage + ", chargesCredits=" + chargesCredits + "]";
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
