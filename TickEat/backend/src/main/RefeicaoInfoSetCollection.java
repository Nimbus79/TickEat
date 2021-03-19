/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ana Rodrigues(Universidade do Minho)
 * License Type: Academic
 */
package main;

import org.orm.*;

public class RefeicaoInfoSetCollection extends org.orm.util.ORMSet {
	public RefeicaoInfoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public RefeicaoInfoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persistent objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(RefeicaoInfo value) {
		if (value != null) {
			super.add(value, null);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(RefeicaoInfo value) {
		super.remove(value, null);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(RefeicaoInfo value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public RefeicaoInfo[] toArray() {
		return (RefeicaoInfo[]) super.toArray(new RefeicaoInfo[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id</li>
	 * <li>nome</li>
	 * <li>ativo</li>
	 * <li>horaInicio</li>
	 * <li>horaFim</li>
	 * <li>horaLimite</li>
	 * <li>desconto</li>
	 * <li>taxaCancelamento</li>
	 * <li>segunda</li>
	 * <li>terca</li>
	 * <li>quarta</li>
	 * <li>quinta</li>
	 * <li>sexta</li>
	 * <li>sabado</li>
	 * <li>domingo</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public RefeicaoInfo[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id</li>
	 * <li>nome</li>
	 * <li>ativo</li>
	 * <li>horaInicio</li>
	 * <li>horaFim</li>
	 * <li>horaLimite</li>
	 * <li>desconto</li>
	 * <li>taxaCancelamento</li>
	 * <li>segunda</li>
	 * <li>terca</li>
	 * <li>quarta</li>
	 * <li>quinta</li>
	 * <li>sexta</li>
	 * <li>sabado</li>
	 * <li>domingo</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public RefeicaoInfo[] toArray(String propertyName, boolean ascending) {
		return (RefeicaoInfo[]) super.toArray(new RefeicaoInfo[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return tickeatPersistentManager.instance();
	}
	
}

