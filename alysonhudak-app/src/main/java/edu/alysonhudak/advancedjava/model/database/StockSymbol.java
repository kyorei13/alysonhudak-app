package edu.alysonhudak.advancedjava.model.database;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Models the Stock Symbol table
 *
 * @author Alyson Hudak
 */
@Entity
@Table(name = "stock_symbol", schema = "", catalog = "stocks")
public class StockSymbol implements DatabasesAccessObject {
    private int id;
    private String symbol;

    public StockSymbol(){

    }

    public StockSymbol(Stock stock){
        this.symbol = stock.getSymbol();
    }

    /**
     * Primary Key - Unique ID for a particular row in the stock symbol table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the stock symbol table.
     * This method should not be called by client code. The value is managed internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the stock symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the stock symbol
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * This method compares two objects to ensure they are equal
     */
    @Override
    public boolean equals(Object o) {
        //if the object is equal to itself, return true
        if (this == o) return true;

        //check if o is null or is not an instance of this class
        // if so, return false
        if (o == null || getClass() != o.getClass()) return false;

        //cast o to be of type person
        StockSymbol that = (StockSymbol) o;

        //compares each attribute and return true or false result
        if (id != that.id) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;

        return true;
    }

    /**
     * This method constructs and returns a hashcode value for the stock symbol object
     * @return a hashcode value for the stock symbol object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}