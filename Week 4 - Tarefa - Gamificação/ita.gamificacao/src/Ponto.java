package src;

import java.io.Serializable;

public class Ponto implements Serializable, Comparable<Ponto>{
	private static final long serialVersionUID = 1L;
	
	private String _user;
	private String _type;
	private int _value;

	public Ponto(String user, int value, String type) {
		_user = user;
		_type = type;
		_value = value;
	}

	public String get_user() {
		return _user;
	}
	
	public String get_type() {
		return _type;
	}
	
	public int get_value() {
		return _value;
	}
	
	@Override
	public boolean equals(Object reference){
        if(reference instanceof Ponto){
             Ponto p = (Ponto) reference;
             
             boolean usuarioEIgual = _user.equals(p.get_user());
             boolean tipoEIgual = _type.equals(p.get_type());
             boolean valorEIgual = _value == p.get_value();
             
             if (usuarioEIgual && valorEIgual && tipoEIgual)
     			return true;
        }
		return false;
    }

	@Override
	public int compareTo(Ponto reference) {
		if(_value == reference.get_value())  
			return 0;  
		else if(_value > reference.get_value())  
			return 1;  
		else  
			return -1; 
	}
	
	@Override
	public String toString() {
		return new StringBuffer("Usuario: ")
				.append(_user)
 	   			.append(" Tipo : ")
 	   			.append(_type)
 	   			.append(" Valor : ")
 	   			.append(_value)
 	   			.toString();
	   }
}
