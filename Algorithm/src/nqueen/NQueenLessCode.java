package nqueen;

public class NQueenLessCode {
	
	private int rowNum;
	private int resultNum;
	private int[] result;
	private long useTime;
	private long recursion;
	
	public NQueenLessCode(int n) {
		// TODO Auto-generated constructor stub
		rowNum = n;
		resultNum = 0;
		result = new int [n];
		useTime = 0;
		recursion = 0;
		for(int i = 0; i<result.length; i++){
			result[i] = -1;
		}
	}
	
	public static void start() {
		NQueenLessCode NQP = new NQueenLessCode(12);
		NQP.searchQ();
	}

	public void printResult(){
		for(int j = 0; j < rowNum; j++){
			for(int k = 0; k < rowNum; k++){
				if(k != result[j]){
					System.out.print("0");
				}else{
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
		System.out.print(resultNum+"===================================\n");
	}
	
	public void dfs(int row){
		if(row == rowNum){//find a result.
			resultNum++;
//			printResult();
			return;
		}else{
			result[row]++;//init result[row]=-1
			while(result[row]<rowNum){	
				boolean isFit = true;  //to judge if this position is a right position.
				if(row == 0){
					recursion++;
					dfs(row+1);
				}else{
					for(int i = 0; i<row; i++){
						if(!((Math.abs(result[i]-result[row]) != Math.abs(i-row)) && (result[i] != result[row]) && (result[row]<rowNum))){
							isFit = false;
							break;
						}
					}
					if(isFit){//if is a right position.
						recursion++;
						dfs(row+1);
					}
				}
				result[row]++;
			}
		}
		result[row] = -1;//reset the result[row]
	}
	
	public void searchQ(){
		long preTime = System.currentTimeMillis();
		dfs(0);
		long aftTime = System.currentTimeMillis();
		useTime = aftTime - preTime;
		System.out.println("Use: "+ useTime + "ms.");
		System.out.println("recursion:"+recursion);
	}

}
