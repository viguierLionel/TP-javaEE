/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pedago
 */
public class CodeEntity {
	// TODO : ajouter les autres propriétés
	private int codeId;
	private float taux;

	public CodeEntity(int code, float taux) {
		this.codeId = code;
		this.taux = taux;
	}

	/**
	 * Get the value of customerId
	 *
	 * @return the value of customerId
	 */
	public int getCodeId() {
		return codeId;
	}

	/**
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * Get the value of addressLine1
	 *
	 * @return the value of addressLine1
	 */
}
