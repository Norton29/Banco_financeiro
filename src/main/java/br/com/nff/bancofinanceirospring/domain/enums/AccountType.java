package br.com.nff.bancofinanceirospring.domain.enums;



public enum AccountType {

	SALARY(1),
	CHECKING(2),
	SAVINGS(3);
	
	
	private int code;
	
	private AccountType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static AccountType valueOf(int code) {
		for (AccountType value : AccountType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Code");
	}
	
}

