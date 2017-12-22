package tableClasses;

import Convertor.TypeConvertor;
import enums.EErrorCodes;
import enums.EInstructionSet;
import jdk.nashorn.internal.ir.Symbol;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by BobrZlosyn on 17.12.2017.
 */
public class TableOfSymbols {


    private static ArrayList <Symbol> tableOfSymbols = new ArrayList<>();
    private static Stack <Integer> changesInParentID = new Stack<>();
    private static Stack <Integer> changesInObjectID = new Stack<>();
    private static int actualLevel = 0;
    private static int parentID = -1;
    private static int objectID = 0;
    private static int actObjectID = 0;
    public static String filepath = "";

    public static class Symbol {
        private String name, variableType;
        private boolean isVariable, isConst;
        private int level, address, size, parentID, objectID;

        public Symbol(int parentID, int objectID, String name, boolean isVariable, int level, int address,
                                                    String variableType, int size, boolean isConst){

            this.name = name;
            this.isVariable = isVariable;
            this.level = level;
            this.address = address;
            this.variableType = variableType;
            this.size = size;
            this.isConst = isConst;
            this.parentID = parentID;
            this.objectID = objectID;
        }

        public int getLevel() {
            return level;
        }

        public int getAddress() {
            return address;
        }

        public int getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public String getVariableType() {
            return variableType;
        }

        public boolean isVariable() {
            return isVariable;
        }

        public boolean isConst() {
            return isConst;
        }

        public int getObjectID() {
            return objectID;
        }

        public int getParentID() {
            return parentID;
        }

    }

    public static boolean addSymbol(Token ctxToken, String name, boolean isVariable, String variableType, int size, boolean isConst){

        if (findByNameActLevel(name, isVariable) != null) {
            ErrorHandle.addError(EErrorCodes.VARIABLE_EXISTS,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        int address = getNextSymbolVariableAddress();
        if (!tableOfSymbols.add(new Symbol(parentID, objectID, name, isVariable, actualLevel, address, variableType, size, isConst))) {
            ErrorHandle.addError(EErrorCodes.UNKNOW_ERROR,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        if (isVariable) {
            EInstructionSet.doInstruction(EInstructionSet.STORE, address);
        }

        return true;
    }

    public static boolean addSymbol(Token ctxToken, String name, boolean isVariable, String variableType, int size, boolean isConst, boolean isEmpty){

        if (findByNameActLevel(name, isVariable) != null) {
            ErrorHandle.addError(EErrorCodes.VARIABLE_EXISTS,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        int address = getNextSymbolVariableAddress();
        if (!tableOfSymbols.add(new Symbol(parentID, objectID, name, isVariable, actualLevel, address, variableType, size, isConst))) {
            ErrorHandle.addError(EErrorCodes.UNKNOW_ERROR,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        if (isVariable && !isEmpty) {
            EInstructionSet.doInstruction(EInstructionSet.STORE, address);
        }

        return true;
    }

    public static boolean addSymbol(Token ctxToken, String name, boolean isVariable, int address, String variableType, int size, boolean isConst){

        if (findByNameActLevel(name, isVariable) != null) {
            ErrorHandle.addError(EErrorCodes.VARIABLE_EXISTS,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        if (!tableOfSymbols.add(new Symbol(parentID, objectID, name, isVariable, actualLevel, address, variableType, size, isConst))) {
            ErrorHandle.addError(EErrorCodes.UNKNOW_ERROR,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        if (isVariable) {
            EInstructionSet.doInstruction(EInstructionSet.STORE, address);
        }

        return true;
    }

    public static Symbol findByAdress(int address){
        for (Symbol symbol : tableOfSymbols){
            if (symbol.getAddress() == address){
                return symbol;
            }
        }
        return null;
    }

    public static Symbol findByNameActLevel(String name, boolean isVariable){
        for (Symbol symbol : tableOfSymbols){
            if (symbol.getObjectID() == objectID && symbol.getName().equals(name) && (isVariable == symbol.isVariable())){
                return symbol;
            }
        }

        return null;
    }

    public static Symbol findByNameAllLevels(String name, boolean isVariable){

        int parent = parentID;
        int object = objectID;
        int pomObject = -1;
        boolean lastRound = true;

        while (lastRound) {
            if (parent == -1) {
                lastRound = false;
            }
            for (int i = 0; i < tableOfSymbols.size(); i++) {
                Symbol symbol = tableOfSymbols.get(i);

                if(symbol.getObjectID() == object) {
                    parent = symbol.getParentID();
                    pomObject = symbol.getObjectID();

                    if (symbol.getName().equals(name) && (isVariable == symbol.isVariable())){
                        return symbol;
                    }
                }
            }

            object = pomObject;
        }

        return null;
    }

    public static void removeAllInLevel(int level){
        int size = tableOfSymbols.size();
        for (int i = 0; i < size; i++){
            if (tableOfSymbols.get(i).getLevel() == level) {
                tableOfSymbols.remove(i);
                i--;
            }
        }

    }

    public static void setLevel(boolean isDeeper){
        if(isDeeper) {
            if(parentID == 0) {
                changesInParentID.push(parentID);
                parentID = objectID;

            }else {
                parentID++;
                changesInParentID.push(-1);
            }

            changesInObjectID.push(objectID);
            objectID = ++actObjectID;
            actualLevel++;

        }else {
            actualLevel--;
            parentID = changesInParentID.pop();
            objectID = changesInObjectID.pop();
        }
    }

    public static int getActualLevel() {
        return actualLevel;
    }

    public static int getParentLevel() {
        int parentLevel = getActualLevel() - 1;
        return (parentLevel > 0) ? parentLevel : 0;
    }

    public static Symbol getLastSymbol(){
        return tableOfSymbols.get(tableOfSymbols.size() - 1);
    }



    public static int getNextSymbolVariableAddress(){
        Symbol symbol = null;
        for (Symbol sym : tableOfSymbols){
            if (sym.getObjectID() == objectID && (sym.isVariable())){
                symbol = sym;
            }
        }

        if (symbol == null) {
            return 3;
        }else {
            return symbol.getAddress() + symbol.getSize() + 1;
        }

    }
}