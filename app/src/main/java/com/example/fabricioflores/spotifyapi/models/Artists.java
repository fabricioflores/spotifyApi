
package com.example.fabricioflores.spotifyapi.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Artists {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * No args constructor for use in serialization
     *
     */
    public Artists() {
    }

    /**
     *
     * @param total
     * @param limit
     * @param previous
     * @param items
     * @param next
     * @param offset
     * @param href
     */
    public Artists(String href, List<Item> items, Integer limit, Object next, Integer offset, Object previous, Integer total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    /**
     *
     * @return
     *     The href
     */
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href
     *     The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     * @return
     *     The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     *     The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
     *     The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     *     The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     *     The next
     */
    public Object getNext() {
        return next;
    }

    /**
     *
     * @param next
     *     The next
     */
    public void setNext(Object next) {
        this.next = next;
    }

    /**
     *
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     *     The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     *     The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     *
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
