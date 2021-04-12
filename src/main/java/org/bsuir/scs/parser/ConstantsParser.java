package org.bsuir.scs.parser;

import org.bsuir.scs.util.DefaultParameters;

import java.util.ArrayList;
import java.util.List;

public class ConstantsParser {

    public List<String> getConstants(String string) {

        List<String> listOfConstants = new ArrayList<>();

        int i = 0;
        while (i < string.length()) {
            if (string.charAt(i) == '(') {
                int beginIndex = ++i;

                while (string.charAt(++i) != ' ');

                listOfConstants.add("\t\t" + string.substring(beginIndex, i));
            }
            ++i;
        }

        return listOfConstants;
    }

    public String replaceConstantsWithLinks(String string) {
        StringBuilder stringBuilder = new StringBuilder();
//todo ( amount should be equal )
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == '(') {
                stringBuilder.append(DefaultParameters.LINK_START);

                while (string.charAt(++i) != ' ') {
                    stringBuilder.append(string.charAt(i));
                }
                stringBuilder.append("\">");
            } else if (string.charAt(i) == ')') {
                stringBuilder.append(DefaultParameters.LINK_END);
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
