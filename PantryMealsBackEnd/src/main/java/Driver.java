import java.util.HashSet;
import java.util.Set;

import com.revature.models.Recipe;
import com.revature.services.RecipeService;

public class Driver {

	public static void main(String[] args) {
		RecipeService rs = new RecipeService();
		
		
		Recipe r = new Recipe(1,"title","link","ingredients","thumbnail",null);
		Recipe q = new Recipe(1,"title","link","Apples","thumbnail",null);
		
		Set<Recipe> results = new HashSet<Recipe>();
		results.add(r);
		results.add(q);
		String[] ingredients = {"Apples"};
		
		
		System.out.print(rs.filterExtraIng(results, ingredients));
		System.out.print("Finished");

	}

}
