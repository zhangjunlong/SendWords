package com.openthinks.woms.util;

import java.util.ArrayList;
import java.util.List;

public class Page
{

    public Page()
    {
        first = true;
        last = true;
        pageCount = 0;
        count = 0;
        next = 0;
        previous = 0;
        size = 10;
        number = 0;
        contents = new ArrayList();
    }

    public Page(int count, int number, int size)
    {
        if(size < 1)
            size = 10;
        setPageCount(count / size);
        if(count % size > 0)
            setPageCount(getPageCount() + 1);
        if(number < 1)
            setNumber(1);
        else
        if(number > getPageCount())
            setNumber(getPageCount());
        else
            setNumber(number);
        setCount(count);
        setSize(size);
        setFirst(getNumber() == 1);
        setLast(getNumber() >= getPageCount());
        if(getFirst())
            setPrevious(1);
        else
            setPrevious(getNumber() - 1);
        if(getLast())
            setNext(getNumber());
        else
            setNext(getNumber() + 1);
        indexs = new int[pageCount];
        for(int i = 0; i < pageCount; i++)
            indexs[i] = i + 1;

    }

    public boolean getFirst()
    {
        return first;
    }

    public void setFirst(boolean first)
    {
        this.first = first;
    }

    public boolean getLast()
    {
        return last;
    }

    public void setLast(boolean last)
    {
        this.last = last;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    public int getNext()
    {
        return next;
    }

    public void setNext(int next)
    {
        this.next = next;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getPrevious()
    {
        return previous;
    }

    public void setPrevious(int previous)
    {
        this.previous = previous;
    }

    public List getContents()
    {
        return contents;
    }

    public void setContents(List contents)
    {
        this.contents = contents;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int[] getIndexs()
    {
        return indexs;
    }

    public void setIndexs(int indexs[])
    {
        this.indexs = indexs;
    }

    private boolean first;
    private boolean last;
    private int pageCount;
    private int count;
    private int next;
    private int previous;
    private int size;
    private int number;
    private List contents;
    private int indexs[];
}