package project3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class tastehealth extends burger {
public void burger(){
	this.taste=taste;
	this.health=health;
	this.id=id;
      	
}

public static int count=0;
	    public static void main(String[] args)
	    {
	    	int n,len;
	    	burger[] burg= new burger[100];
	    	  float arrayOut[] = new float[100]; 
	        System.out.println("Generating a random array...please input number of elements");
	        Scanner in=new Scanner(System.in);
	        n=in.nextInt(); 
	        
	        for (int i = 0; i < n; i++) {
	    		burg[i]=new burger();
	    		arrayOut[i]=0;
	    	}
	        
	        randomArray(n,burg);
	        burger[] burg1=new burger[100];
	        sort(burg,n);
	        for (int i = 0; i < n; i++) {
	        	int j=i+1;
	        System.out.println("Burger "+j+"   health:"+burg[i].health+"   taste "+burg[i].taste);
	        }
	        
        //���ÿ�μ���ʱarrayOut��������ݣ����ڹ۲�
	        len=get(arrayOut, burg, n);
	        System.out.println(count);
	        System.out.println("LIS length nlogn is:"+len); //�������������еĳ���
        
	    }

	    public static void randomArray(int n, burger[] burg){ //����һ��10���ڵ����飬����Ϊ10
	        Random random=new Random();
	        for (int i = 0; i < n; i++) {
	            burg[i].health=random.nextFloat()+(float)random.nextInt(10);
	            burg[i].taste=random.nextFloat()+(float)random.nextInt(10); 
	            burg[i].id=i;
	        }
	        return;
	    }

	    public static int get(float arrayOut[], burger burg[], int n){ //��ȡ����������еĳ���

	        int position;
	        int len=1;

	       String a[]=new String [50];
	       a[0]=Integer.toString(burg[0].id);
	        arrayOut[0]=burg[0].health; //��ʼ��������Ϊ1��LISĩβΪarrayIn[0]
	        
	        for (int i = 1; i < n; i++) {
	            if(burg[i].health>arrayOut[len-1])
	            {   
	            	len++;
	            	arrayOut[len-1]=burg[i].health;
	            	count++;
	            }
	            else
	            {   
	            	position=BinarySearchPosition(arrayOut, 0, len-1, burg[i].health);
	            	count++;
	            	arrayOut[position]=burg[i].health;}
	            	
	          
	            }
         
	        

	        return len;
	    }
	    
	    public static int BinarySearchPosition(float[] arrayOut,int left,int right,float key){ //���ֲ���Ҫ�滻��λ��

	        int mid;

	        if (arrayOut[right]<key) {
	            return right+1;
	        }else {
	            while(left<right){
	                mid=(left+right)/2;
	                if (arrayOut[mid]<key) {
	                    left=mid+1;
	                }else {
	                    right=mid;
	                }       
	            }
	            count++;   
	            return left;
	        }

	    }

	  
	    	
	    	
	  
	    
	    
    
	  
	    public static void sort(burger burg[],int n)
	    {
	          
	    	    burger tmp;
	    		for (int i = 0; i < n - 1; i++){  
	    	        for (int j = i + 1; j < n; j++){  
	    	            if (burg[j].taste < burg[i].taste) {  
	    	                tmp = burg[i];  
	    	                burg[i] = burg[j];  
	    	                burg[j] = tmp;  
	    	               
	    	            }  
	    	        }  
	    		}

	    	  	return ;		
	    }
	    	
	}

