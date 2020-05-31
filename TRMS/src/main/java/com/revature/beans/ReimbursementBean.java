package com.revature.beans;

public class ReimbursementBean {
	private int reimbursement_id;
	private String status;
	private int amount;
	public ReimbursementBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementBean(int reimbursement_id, String status, int amount) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.status = status;
		this.amount = amount;
	}
	public int getReimbursement_id() {
		return reimbursement_id;
	}
	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ReimbursementBean [reimbursement_id=" + reimbursement_id + ", status=" + status + ", amount=" + amount
				+ "]";
	}
	
	
	
	
	
}
