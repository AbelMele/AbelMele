public class SentenceWordCount {
    // Method Structure given 
    public int mostWordsMatch(String[] sentences)
    {
        int maxWordCount = 0;
          //You are given an array of strings sentences, where each sentences[i] represents a single sentence. 
        for (String sentence : sentences)
        {
            /*  instade we can use this for loop
            for (int i = 0; i < sentences.length; i++) {
           String sentence = sentences[i];
           */           
          String[] words = sentence.split(" ");
          int wordCount = words.length;
             
            if (wordCount > maxWordCount){
                maxWordCount = wordCount;
            }

        }
        //Return the maximum number of the words that appear in a single sentence
        return maxWordCount;

    }
    public static void main(String[] args){
        SentenceWordCount solution = new SentenceWordCount();
        // Input Sentences 
        String[] sentences = {
            "Is Abebe takes Full-Stack and QA ?",
            " i think so",
            "Oh that is great "
        };
        int maxWords = solution.mostWordsMatch(sentences);
        System.out.println("Maximum number of words in a single sentence: " + maxWords);
    }  
}

