package metier;

import dao.IDao ;
 import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component ;

 @Component (" metier ")

public class MetierImpl implements IMetier {

	 @Autowired
	 @Qualifier("dao") 
	 private IDao dao ;
	 @Override
	  public double calcul () {
	  return dao . getValue () * 2;
	  }
	public void setDao(IDao daoMock) {
		// TODO Auto-generated method stub
		
	}


}
