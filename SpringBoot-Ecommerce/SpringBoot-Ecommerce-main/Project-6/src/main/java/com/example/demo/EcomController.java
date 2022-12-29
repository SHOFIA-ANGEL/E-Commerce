package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()

public class EcomController {
	
	@Autowired Ecom_repo ob;

	@PostMapping("/saveProduct")
		public String saveProduct(@RequestBody Ecommerce com)
		{
		Ecommerce e = new Ecommerce();
		
		int id= com.getProductId();
		String name = com.getProductName();
		String des= com.getDescription();
		int qnty = com.getQuantity() ;
		int price=com.getPrice();
		String type=com.getType();
		
		e.setProductId(id);
		e.setProductName(name);
		e.setDescription(des);
		e.setQuantity(price);
		e.setPrice(price);
		e.setType(type);
		
		Ecommerce first = new Ecommerce(id,name,des,qnty,price,type);
		ob.save(first);
		
	return "Added successfully";

		}
	
	@GetMapping("/getproducts")
    public List<Ecommerce> getAllproducts()
    {

        return ob.findAll();

    }
    
   
    
    @GetMapping("/products/type/{name}")
	public List<Ecommerce> getProductsByType(@PathVariable("name") String name)   
	{  
		return ob.findByType(name);  
	}
	
		
    @PostMapping("products/{id}")
    public List<Ecommerce> getProductsById(@PathVariable("id") int id){
    

    	return ob.findById(id);

        
    }
    

	
	@DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
	 
		ob.deleteAllByIdInBatch(id);
		
		return "deleted successfully";
}


}
