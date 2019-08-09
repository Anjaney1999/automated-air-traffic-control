//***********************************************************************************************
//* File: 'PriorityQueue.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/PriorityQueue.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class PriorityQueue extends _eAny
{
    protected Heap queue;
    public int size ()
    {
        return queue.size ();
    }

    public void insert (Node node)
    {
        Heap _vUnshare_20_9 = ((Heap) queue._lClone ());
        queue = _vUnshare_20_9;
        queue.insert (node);
    }

    public Node getMin ()
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == queue.size ())))) throw new _xPre ("PriorityQueue.pd:24,20");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return queue.getMin ();
    }

    public void removeMin ()
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == queue.size ())))) throw new _xPre ("PriorityQueue.pd:30,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        Heap _vUnshare_32_13 = ((Heap) queue._lClone ());
        queue = _vUnshare_32_13;
        queue.removeMin ();
    }

    public void updateNode (_eSeq waypoint, char _t0waypoint, double distance)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == queue.size ())))) throw new _xPre ("PriorityQueue.pd:39,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= distance))) throw new _xPre ("PriorityQueue.pd:40,22");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        int _vLet_index_43_17 = queue.find (waypoint, (char) 0);
        if ((((!((- 1) == _vLet_index_43_17)) && (0 <= _vLet_index_43_17)) && (_vLet_index_43_17 <
            queue.size ())))
        {
            Heap _vUnshare_46_21 = ((Heap) queue._lClone ());
            queue = _vUnshare_46_21;
            queue.update (_vLet_index_43_17, distance);
        }
        else
        {
        }
    }

    public PriorityQueue ()
    {
        super ();
        queue = new Heap ();
    }

    public boolean _lEqual (PriorityQueue _vArg_11_7)
    {
        if (this == _vArg_11_7)
        {
            return true;
        }
        return _vArg_11_7.queue._lEqual (queue);
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == PriorityQueue.class &&
            _lEqual ((PriorityQueue) _lArg));
    }

}


// End of file.
