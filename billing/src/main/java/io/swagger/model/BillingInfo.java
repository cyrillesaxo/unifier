package io.swagger.model;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * BillingBillingInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Table(table = "billing_info")
public class BillingInfo {

	@Column("customer_id")
	@PartitionKey
	@JsonProperty("customer_id")
	private String customerId = null;

	@Column("last_billed_amount")
	@JsonProperty("last_billed_amount")
	private String lastBilledAmount = null;

	@Column("past_due_balance")
	@ClusteringColumn(2)
	@JsonProperty("past_due_balance")
	private String pastDueBalance = null;

	@Column("current_balance")
	@ClusteringColumn(1)
	@JsonProperty("current_balance")
	private String currentBalance = null;

	@Column("balance_due_date")
	@JsonProperty("balance_due_date")
	private String balanceDueDate = null;

	@Column("last_billed_date")
	@JsonProperty("last_billed_date")
	private String lastBilledDate = null;

	@Column("next_bill_date")
	@JsonProperty("next_bill_date")
	private String nextBillDate = null;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BillingInfo lastBilledAmount(String lastBilledAmount) {
		this.lastBilledAmount = lastBilledAmount;
		return this;
	}

	/**
	 * Get lastBilledAmount
	 * 
	 * @return lastBilledAmount
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public String getLastBilledAmount() {
		return lastBilledAmount;
	}

	public void setLastBilledAmount(String lastBilledAmount) {
		this.lastBilledAmount = lastBilledAmount;
	}

	public BillingInfo pastDueBalance(String pastDueBalance) {
		this.pastDueBalance = pastDueBalance;
		return this;
	}

	/**
	 * Get pastDueBalance
	 * 
	 * @return pastDueBalance
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public String getPastDueBalance() {
		return pastDueBalance;
	}

	public void setPastDueBalance(String pastDueBalance) {
		this.pastDueBalance = pastDueBalance;
	}

	public BillingInfo currentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
		return this;
	}

	/**
	 * Get currentBalance
	 * 
	 * @return currentBalance
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

	public BillingInfo balanceDueDate(String balanceDueDate) {
		this.balanceDueDate = balanceDueDate;
		return this;
	}

	/**
	 * Get balanceDueDate
	 * 
	 * @return balanceDueDate
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getBalanceDueDate() {
		return balanceDueDate;
	}

	public void setBalanceDueDate(String balanceDueDate) {
		this.balanceDueDate = balanceDueDate;
	}

	public BillingInfo lastBilledDate(String lastBilledDate) {
		this.lastBilledDate = lastBilledDate;
		return this;
	}

	/**
	 * Get lastBilledDate
	 * 
	 * @return lastBilledDate
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getLastBilledDate() {
		return lastBilledDate;
	}

	public void setLastBilledDate(String lastBilledDate) {
		this.lastBilledDate = lastBilledDate;
	}

	public BillingInfo nextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
		return this;
	}

	/**
	 * Get nextBillDate
	 * 
	 * @return nextBillDate
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingInfo other = (BillingInfo) obj;
		if (balanceDueDate == null) {
			if (other.balanceDueDate != null)
				return false;
		} else if (!balanceDueDate.equals(other.balanceDueDate))
			return false;
		if (currentBalance == null) {
			if (other.currentBalance != null)
				return false;
		} else if (!currentBalance.equals(other.currentBalance))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (lastBilledAmount == null) {
			if (other.lastBilledAmount != null)
				return false;
		} else if (!lastBilledAmount.equals(other.lastBilledAmount))
			return false;
		if (lastBilledDate == null) {
			if (other.lastBilledDate != null)
				return false;
		} else if (!lastBilledDate.equals(other.lastBilledDate))
			return false;
		if (nextBillDate == null) {
			if (other.nextBillDate != null)
				return false;
		} else if (!nextBillDate.equals(other.nextBillDate))
			return false;
		if (pastDueBalance == null) {
			if (other.pastDueBalance != null)
				return false;
		} else if (!pastDueBalance.equals(other.pastDueBalance))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balanceDueDate == null) ? 0 : balanceDueDate.hashCode());
		result = prime * result + ((currentBalance == null) ? 0 : currentBalance.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((lastBilledAmount == null) ? 0 : lastBilledAmount.hashCode());
		result = prime * result + ((lastBilledDate == null) ? 0 : lastBilledDate.hashCode());
		result = prime * result + ((nextBillDate == null) ? 0 : nextBillDate.hashCode());
		result = prime * result + ((pastDueBalance == null) ? 0 : pastDueBalance.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "BillingInfo [customerId=" + customerId + ", lastBilledAmount=" + lastBilledAmount + ", pastDueBalance="
				+ pastDueBalance + ", currentBalance=" + currentBalance + ", balanceDueDate=" + balanceDueDate
				+ ", lastBilledDate=" + lastBilledDate + ", nextBillDate=" + nextBillDate + "]";
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
