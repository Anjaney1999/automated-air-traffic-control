//***********************************************************************************************
//* File: 'Node.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Node.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Node extends _eAny
{
    public _eSeq waypoint;
    public double distance;
    public void updateDistance (double newDistance)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= newDistance))) throw new _xPre ("Node.pd:18,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((0.0 <= newDistance))
        {
            distance = newDistance;
        }
        else
        {
            distance = 0.0;
        }
    }

    public Node (_eSeq _vwaypoint, char _t0_vwaypoint, double _vdistance)
    {
        super ();
        waypoint = _vwaypoint;
        distance = _vdistance;
    }

    public boolean _lEqual (Node _vArg_9_7)
    {
        if (this == _vArg_9_7)
        {
            return true;
        }
        return (_vArg_9_7.waypoint._lEqual (waypoint) && (_vArg_9_7.distance == distance));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Node.class && _lEqual ((Node)
            _lArg));
    }

}


// End of file.
