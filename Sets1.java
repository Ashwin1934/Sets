import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
public class Sets1{

	private ArrayList<HashSet<Integer>> list;

	public Sets1(){
		list = new ArrayList<HashSet<Integer>>();

		int rand = (int)(Math.random()*10)+2;

		for(int i = 0;i<rand;i++){
			HashSet<Integer> hashSet = new HashSet<Integer>();
			while(hashSet.size()<20){
				hashSet.add((int)(Math.random()*60));
			}
			list.add(hashSet);

		}
		//printing out the hashSets with 20 numbers  | task 1
		for(HashSet<Integer> hash:list)
			System.out.println("Hash:"+hash);
		System.out.println();
		//prints out intersection, union, their evens, of 2 hashsets

		/*System.out.println("Intersection(HashSet1,HashSet2):"+Intersection(list.get(0),list.get(1)));
		System.out.println("Union(HashSet1,HashSet2):"+Union(list.get(0),list.get(1)));
		System.out.println("Even Intersection(HashSet1,HashSet2):"+EvenIntersection(list.get(0),list.get(1)));
		System.out.println("Even Union(HashSet1,HashSet2):"+EvenUnion(list.get(0),list.get(1))); */


		//method calls for the whole list of intersections
		ArrayList<HashSet<Integer>> intersectionlist = new ArrayList<HashSet<Integer>>();
		for(int i = 0;i<list.size()-1;i+=2){
			intersectionlist.add(Intersection(list.get(i),list.get(i+1))); //adds intersection of two sets into an array
		}
		//System.out.println("\nIntersectionList"+intersectionlist);
			if(list.size()%2==0){     // recursion to break down list of intersected
				while(intersectionlist.size()>1){
					intersectionlist.set(0,Intersection(intersectionlist.get(0),intersectionlist.get(1)));
					intersectionlist.remove(1);
				}
				System.out.println("\nIntersectionOfAll: "+intersectionlist);
			}
			else
			if(list.size()%2==1){
				while(intersectionlist.size()>1){
					intersectionlist.set(0,Intersection(intersectionlist.get(0),intersectionlist.get(1)));
					intersectionlist.remove(1);
				}
				System.out.println("\nIntersectionOfAll: "+Intersection(intersectionlist.get(0),list.get(list.size()-1)));
			}
		//method calls for the whole list of evenintersections
			ArrayList<HashSet<Integer>> evenintersectionlist = new ArrayList<HashSet<Integer>>();
			for(int i = 0;i<list.size()-1;i+=2){
				evenintersectionlist.add(EvenIntersection(list.get(i),list.get(i+1))); //adds intersection of two sets into an array
			}
			//System.out.println("\nIntersectionList"+intersectionlist);
				if(list.size()%2==0){
					while(evenintersectionlist.size()>1){
						evenintersectionlist.set(0,EvenIntersection(evenintersectionlist.get(0),evenintersectionlist.get(1)));
						evenintersectionlist.remove(1);
					}
					System.out.println("\nEvenIntersectionOfAll: "+evenintersectionlist);
				}
				else
				if(list.size()%2==1){
					while(evenintersectionlist.size()>1){
						evenintersectionlist.set(0,EvenIntersection(evenintersectionlist.get(0),evenintersectionlist.get(1)));
						evenintersectionlist.remove(1);
					}
					System.out.println("\nEvenIntersectionOfAll: "+EvenIntersection(evenintersectionlist.get(0),list.get(list.size()-1)));
		}
		//method calls for the whole list of unions
		ArrayList<HashSet<Integer>> unionlist = new ArrayList<HashSet<Integer>>();
		for(int i = 0;i<list.size()-1;i+=2){
			unionlist.add(Union(list.get(i),list.get(i+1))); //adds union of two sets into an array
		}
		//System.out.println("\nUnionList"+unionlist);
			if(list.size()%2==0){
				while(unionlist.size()>1){
					unionlist.set(0,Union(unionlist.get(0),unionlist.get(1)));
					unionlist.remove(1);
				}
				System.out.println("\nUnionOfAll: "+unionlist);
			}
			else
			if(list.size()%2==1){
				while(unionlist.size()>1){
					unionlist.set(0,Union(unionlist.get(0),unionlist.get(1)));
					unionlist.remove(1);
				}
				System.out.println("\nUnionOfAll: "+Union(unionlist.get(0),list.get(list.size()-1)));
			}
		//method calls for the whole list of evenunions
		ArrayList<HashSet<Integer>> evenunionlist = new ArrayList<HashSet<Integer>>();
		for(int i = 0;i<list.size()-1;i+=2){
			evenunionlist.add(EvenUnion(list.get(i),list.get(i+1))); //adds union of two sets into an array
		}
		//System.out.println("\nUnionList"+unionlist);
			if(list.size()%2==0){
				while(evenunionlist.size()>1){
					evenunionlist.set(0,EvenUnion(evenunionlist.get(0),evenunionlist.get(1)));
					evenunionlist.remove(1);
				}
				System.out.println("\nEvenUnionOfAll: "+evenunionlist);
			}
			else
			if(list.size()%2==1){
				while(evenunionlist.size()>1){
					evenunionlist.set(0,EvenUnion(evenunionlist.get(0),evenunionlist.get(1)));
					evenunionlist.remove(1);
				}
				System.out.println("\nEvenUnionOfAll: "+EvenUnion(evenunionlist.get(0),list.get(list.size()-1)));
			}
	}//end of constructor



	//intersection
	public HashSet<Integer> Intersection(HashSet<Integer> a,HashSet<Integer> b) {
		HashSet<Integer> intersection = new HashSet<Integer>(a);
		intersection.retainAll(b);
		return intersection;
	}

	//even intersection
	public HashSet<Integer> EvenIntersection(HashSet<Integer> a,HashSet<Integer> b){
		HashSet<Integer> intersect = Intersection(a,b);
		HashSet<Integer> evenintersect = new HashSet<Integer>();

		for(Integer i:intersect){
			if(i%2==0)
				evenintersect.add(i);
		}
		return evenintersect;
	}
	//union
	public HashSet<Integer> Union(HashSet<Integer> a,HashSet<Integer> b){
		HashSet<Integer> union = new HashSet<Integer>();
		HashSet<Integer> intersect = Intersection(a,b);
		for(Integer num:a){
			union.add(num);
		}
		for(Integer x:b){
			union.add(x);
		}
		HashSet<Integer> finalunion = new HashSet<Integer>();
		for(Integer num:union){
			if(!intersect.contains(num))
				finalunion.add(num);
		}
		return finalunion;
	}
	//even union
	public HashSet<Integer> EvenUnion(HashSet<Integer> a, HashSet<Integer> b){
		HashSet<Integer> union = Union(a,b);
		HashSet<Integer> evenUnion = new HashSet<Integer>();

		for(Integer num:union){
			if(num%2==0)
				evenUnion.add(num);
		}
		return evenUnion;
	}

	public static void main(String [] args){
		Sets1 app = new Sets1();
	}

}