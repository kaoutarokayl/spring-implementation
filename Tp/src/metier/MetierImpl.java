/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.IDao;


public class MetierImpl implements IMetier{
    private IDao dao;
 public void setDao(IDao dao) {
 this.dao = dao;
 }
 @Override
 public double calcul() {
 return dao.getValue() * 2;
 }
}
