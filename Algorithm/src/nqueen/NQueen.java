package nqueen;

import java.util.ArrayList;

/**alt+shift+j
 * @author mrpan
 *	NQueen NQ = new NQueen(8);
 *	NQ.searchQ();
 *	NQ.printResult();
 */

public class NQueen {
	
	private int rowNum;
	
	private int[] result;
	private ArrayList<Integer> resultList;
	
	private int[] judge1;
	private int[] judge2;
	private int[] judge3;
	
	private long useTime = 0;
	private long recursion;	
	
	public NQueen(int n) {
		// TODO Auto-generated constructor stub
		rowNum = n;
		result = new int [n];
		resultList = new ArrayList<>();
		judge1 = new int[rowNum];
		judge2 = new int[2*rowNum-1];
		judge3 = new int[2*rowNum-1];
		recursion = 0;
		for(int i = 0; i < 2*rowNum-1; i++){
			if(i<rowNum){
				judge1[i]=0;
			}
			judge2[i]=0;
			judge3[i]=0;
		}
		for(int i = 0; i<result.length; i++){
			result[i] = -1;
		}
	}
	
	public static void start() {
		NQueen NQ = new NQueen(12);
		NQ.searchQ();
	}
	
	public void searchQ(){
		long preTime = System.currentTimeMillis();
		dfs(0);
		long aftTime = System.currentTimeMillis();
		useTime = aftTime - preTime;
		System.out.println("Use: "+ useTime + "ms.");
		System.out.println("recursion:"+recursion);
	}
	
	public void dfs(int n){
		if(n == rowNum){
//			add2List();
			return;
		}else{
			for(int i = 0; i < rowNum; i++){
				if(judge1[i] == 0 && judge2[rowNum-n-1+i] == 0 && judge3[n+i]==0){
					int old_result = result[n];
					int old_n = judge1[i];
					int old_nx1 = judge2[rowNum-n-1+i];
					int old_nx2 = judge3[n+i];
					
					judge1[i] = judge2[rowNum-n-1+i] = judge3[n+i] = 1;
					result[n]=i;
					
					recursion++;
					dfs(n+1);
					
					result[n]=old_result;
					judge1[i] = old_n;
					judge2[rowNum-n-1+i] = old_nx1;
					judge3[n+i] = old_nx2;
				}
			}
		}
	}
	
	public void add2List(){
		for(int i = 0; i<result.length; i++){
			resultList.add(result[i]);
		}
//		System.out.println(resultList.size()/rowNum);
	}
	
	public void printResult(){
		int rn = resultList.size()/rowNum;
		for(int i = 0; i < rn; i++){
			for(int j = 0; j < rowNum; j++){
				for(int k = 0; k < rowNum; k++){
					if(k != resultList.get(i*rowNum+j)){
						System.out.print("0");
					}else{
						System.out.print("*");
					}
				}
				System.out.print("\n");
			}
			System.out.print(i+1+"===================================\n");
		}
		System.out.println("Use: "+ useTime + "ms.");
	}	
}
