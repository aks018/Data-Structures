package Trie;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;

public class DataStructuresConstants {
    String sampleParagraph ="Climate warming, whatever one concludes about its effect on the earth, " +
            "is insufficiently understood as a concept that has been constructed by scientists, " +
            "politicians and others, argues David Demerrit, a lecturer in geography at King's College London, " +
            "in an exchange with Stephen H. Schneider, a professor of biological sciences at Stanford University. " +
            "Many observers consider the phenomenon's construction -- as \"" +
            "a global-scale environmental problem caused by the universal physical properties of greenhouse gases\" -- " +
            "to be reductionist, Mr. Demerrit writes. Yet \"this reductionist formulation serves a variety of political purposes,\" " +
            "including obscuring the role of rich nations in producing the vast majority of the greenhouse gases. " +
            "Mr. Demerrit says his objective is to unmask the ways that scientific judgments \"have both reinforced " +
            "and been reinforced by certain political considerations about managing\" global warming. " +
            "Scientific uncertainty, he suggests, is emphasized in a way that reinforces dependence on experts. " +
            "He is skeptical of efforts to increase public technical knowledge of the phenomenon, and instead urges efforts \"" +
            "to increase public understanding of and therefore trust in the social process through which the facts are " +
            "scientifically determined.\" In response, Mr. Schneider agrees that \"the conclusion that science is at least partially " +
            "socially constructed, even if still news to some scientists, is clearly established.\" He bluntly states, however, " +
            "that if scholars in the social studies of science are to be heard by more scientists, they will have to \"be careful " +
            "to back up all social theoretical assertions with large numbers of broadly representative empirical examples.\" " +
            "Mr. Schneider also questions Mr. Demerrit's claim that scientists are motivated by politics to conceive of " +
            "climate warming as a global problem rather than one created primarily by rich nations: \"Most scientists are " +
            "woefully unaware of the social context of the implications of their work and are too naive to be politically " +
            "conspiratorial.\" He says: \"What needs to be done is to go beyond platitudes about values embedded in science and " +
            "to show explicitly, via many detailed and representative empirical examples, precisely how those social factors affected " +
            "the outcome, and how it might have been otherwise if the process were differently constructed.\"";

     String[] dictionaryArr = sampleParagraph.split("\\W+");

     public ArrayList<String> getDictionary(String[] arr)
     {
         HashSet set = new HashSet();
         ArrayList<String> dictionary = new ArrayList<>();
         for(String s : arr)
         {
             if(!set.contains(s.toLowerCase())){
                 dictionary.add(s.toLowerCase());
             }
             else
                 set.add(s.toLowerCase());
         }
         return dictionary;
     }


}
