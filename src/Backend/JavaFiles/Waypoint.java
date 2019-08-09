//***********************************************************************************************
//* File: 'Waypoint.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Waypoint.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Waypoint extends _eAny
{
    final void _lc_Waypoint (String _lArg)
    {
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= x))) throw new _xClassInvariantItem ("Waypoint.pd:14,15", _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= y))) throw new _xClassInvariantItem ("Waypoint.pd:15,15", _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
    }

    protected void _lClassInvariantCheck (String _lArg)
    {
        _lc_Waypoint (_lArg);
    }

    public _eSeq id;
    public double x;
    public double y;
    public _eSeq neighbours;
    public void setNeighbours (_eSeq newList, _eSeq _t0newList, char _t1newList)
    {
        _lClassInvariantCheck ("Waypoint.pd:25,13");
        neighbours = newList;
        _lClassInvariantCheck ("Waypoint.pd:27,9");
    }

    public void addNeighbour (_eSeq waypoint, char _t0waypoint)
    {
        _lClassInvariantCheck ("Waypoint.pd:32,11");
        if (((- 1) == neighbours.findFirst (((_eAny) waypoint))))
        {
            neighbours = neighbours.append (((_eAny) waypoint));
        }
        else
        {
        }
        _lClassInvariantCheck ("Waypoint.pd:34,7");
    }

    public Waypoint (_eSeq _vid, char _t0_vid, double _vx, double _vy)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= _vx))) throw new _xPre ("Waypoint.pd:44,9");
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
                if (!((0.0 <= _vy))) throw new _xPre ("Waypoint.pd:45,9");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        id = _vid;
        x = _vx;
        y = _vy;
        neighbours = new _eSeq ();
        _lc_Waypoint ("Waypoint.pd:47,7");
    }

    public Waypoint (double _vx, double _vy)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= _vx))) throw new _xPre ("Waypoint.pd:52,7");
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
                if (!((0.0 <= _vy))) throw new _xPre ("Waypoint.pd:53,7");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        x = _vx;
        y = _vy;
        id = _eSystem._lString ("NaN");
        neighbours = new _eSeq ();
        _lc_Waypoint ("Waypoint.pd:57,5");
    }

    public boolean _lEqual (Waypoint _vArg_7_7)
    {
        if (this == _vArg_7_7)
        {
            return true;
        }
        _lClassInvariantCheck ("Waypoint.pd:7,7");
        return (((_vArg_7_7.id._lEqual (id) && (_vArg_7_7.x == x)) && (_vArg_7_7.y == y)) &&
            _vArg_7_7.neighbours._lEqual (neighbours));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Waypoint.class && _lEqual ((
            Waypoint) _lArg));
    }

}


// End of file.
