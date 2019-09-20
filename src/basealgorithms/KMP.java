package common;
public class KMP{
    public int[] getNext(char[] pattern){
        int[] next=new int[pattern.length];
        next[0]=-1;
        int i=0,j=-1;
        while(i<pattern.length){
            if(j==-1||pattern[i]==pattern[j]){
                i++;
                j++;
                if(i>=pattern.length)break;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
        return next;
    }

    public int kmp(String source,String pattern){
        int[] next=getNext(pattern.toCharArray());

        int i=0,j=0,max=0;
        while(i<source.length()&&j<pattern.length()){
            if(j==-1||source.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                max=Math.max(j, max);
            }else{
                j=next[j];
            }
        }
        
        return max;
    }

    public static void main(String[] args){
        String source="ababababca";
        String pattern="abababca";
        System.out.println(new KMP().kmp(source, pattern));
    }

}