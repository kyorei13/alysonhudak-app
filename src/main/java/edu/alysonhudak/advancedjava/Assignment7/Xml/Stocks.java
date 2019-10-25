package edu.alysonhudak.advancedjava.Assignment7.Xml;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}stock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stock"
})
@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject {

    @XmlElement(required = true)
    protected List<Stock> stock;

    /**
     * Gets the value of the stock property.
     *
     * @return
     *     possible object is
     *     {@link Stock }
     *
     */
    public List<Stock> getStock() {
        if (stock == null) {
            stock = new ArrayList<Stock>();
        }
        return stock;
    }


    @Override
    public String toString() {
        String returnValue = "";
        for (int x = 0; x < stock.size(); x++){
            returnValue = returnValue.concat("Stock{" +
                    "stock=" + stock.get(x) +
                    '}');
        }
        return returnValue;
    }
}