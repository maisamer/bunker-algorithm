
public class BunkerAlg {
	private int available[];
	private int max[][];
	private int allocate[][];
	private int need[][];
	int numofRes ; 
	int numofProc;
	public BunkerAlg(int available[],int max[][],int allocate[][],int need[][],int nemofRes,int numofProc)
	{
		this.available=available;
		this.max=max;
		this.allocate=allocate;
		this.need=need;
		this.numofProc=numofProc;
		this.numofRes=nemofRes;
	}
	public void request (int proNum,int req[])
	{
		int oldneed[]=copyArray(need[proNum],numofRes);
		int oldAvailable[]=copyArray(available,numofRes);
		int oldAllocted[]=copyArray(allocate[proNum],numofRes);
		if(lessThan(req, available, numofRes)&&lessThan(req, second, size))
		{
			
		}
		if(!safetyAlg())
		{
			need[proNum]=copyArray(oldneed,numofRes);
			available=copyArray(oldAvailable,numofRes);
			allocate[proNum]=copyArray(oldAllocted,numofRes);
			
		}
		
		
	}
	public void realise ()
	{
		
	}
	public boolean safetyAlg()
	{
		int work[]=copyArray(available, numofRes);
		int old[]=new int[numofRes];
		boolean finish[]=new boolean[numofProc];
		while(true)
		{
			int counter=0;
			old=copyArray(work,numofRes);
			for(int i=0;i<numofProc;i++)
			{
				if(lessThan(need[i],work,numofRes))
				{
					if(!finish[i])
					{
						for(int j=0;j<numofRes;j++)
							work[j]+=allocate[i][j];
					}
				}
				else{
					if(!finish[i])
						counter++;
					
				}
			}
			if(counter==0)
			{
				return true;
			}
			else if(equalArray(work, old, numofRes))
			{
				return false;
			}
			
		}
		
		
	}
	private boolean equalArray(int [] first,int []second,int size)
	{
		for(int j=0;j<size;j++)
			if(first[j]!=second[j])
				return false;
		return true;
	}
	private int [] copyArray(int input[],int size)
	{
		int res[]=new int [size];
		for(int i=0;i<size;i++)
			res[i]=input[i];
		return res;
	}
	private boolean lessThan(int []first,int[]second,int size)
	{
		for(int i=0;i<size;i++)
			if(first[i]>second[i])
				return false;
		return true;
	}

}
