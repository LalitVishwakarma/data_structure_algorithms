package practice.DynamicProgramming;

class Solution
{

    static int PrintMinNumberForPattern(String pattern)
    {
        if(pattern.length() > 8)
            return -1;
        int currentMax = 0;
        int lastEntry = 0;
        int j;

        int[] resultCharArray = new int[pattern.length() + 1];
        int resultIndex = 0;
        for (int i = 0; i < pattern.length(); i++)
        {
            int noOfNextM = 0;

            switch (pattern.charAt(i))
            {
                case 'N':
                    j = i + 1;
                    while (j < pattern.length() && pattern.charAt(j) == 'M')
                    {
                        noOfNextM++;
                        j++;
                    }
                    if (i == 0)
                    {
                        currentMax = noOfNextM + 2;
                        resultCharArray[resultIndex++] = ++lastEntry;
                        resultCharArray[resultIndex++] = currentMax;
                        lastEntry = currentMax;
                    }
                    else
                    {
                        currentMax = currentMax + noOfNextM + 1;
                        lastEntry = currentMax;
                        resultCharArray[resultIndex++] = lastEntry;
                    }

                    for (int k = 0; k < noOfNextM; k++)
                    {
                        resultCharArray[resultIndex++] = --lastEntry;
                        i++;
                    }
                    break;

                case 'M':
                    if (i == 0)
                    {
                        j = i + 1;
                        while (j < pattern.length()&&pattern.charAt(j) == 'M')
                        {
                            noOfNextM++;
                            j++;
                        }
                        currentMax = noOfNextM + 2;
                        resultCharArray[resultIndex++] = currentMax;
                        resultCharArray[resultIndex++] = currentMax - 1;

                        lastEntry = currentMax - 1;
                    }
                    else
                    {
                        resultCharArray[resultIndex++] = lastEntry-1;
                        lastEntry--;
                    }
                    break;
                default: return -1;
            }
        }
        int resultNumber = 0;
        for(int i =0; i < resultIndex; i++){
            resultNumber *= 10;
            resultNumber += resultCharArray[i];
        }
        return resultNumber;
    }

    // Driver code
    public static void main(String[] args)
    {
        System.out.println(PrintMinNumberForPattern("MNM"));
    }
}
