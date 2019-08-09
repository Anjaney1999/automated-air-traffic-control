//***********************************************************************************************
//* File: 'Edge.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Edge.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Edge extends _eAny
{
    final void _lc_Edge (String _lArg)
    {
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((0.0 <= starting.x) && (0.0 <= starting.y)))) throw new _xClassInvariantItem
                    ("Edge.pd:21,24", _lArg);
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
                if (!(((0.0 <= ending.x) && (0.0 <= ending.y)))) throw new _xClassInvariantItem (
                    "Edge.pd:22,22", _lArg);
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
                if (!((0.0 <= distance))) throw new _xClassInvariantItem ("Edge.pd:24,22", _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
    }

    protected void _lClassInvariantCheck (String _lArg)
    {
        _lc_Edge (_lArg);
    }

    public Waypoint starting;
    public Waypoint ending;
    public double distance;
    public Vector direction;
    public int _lRank (Edge otherPath)
    {
        if (this == otherPath)
        {
            return _eRank.same;
        }
        _lClassInvariantCheck ("Edge.pd:35,3");
        return ((distance < otherPath.distance) ?
        _eRank.below : (otherPath.distance < distance) ?
        _eRank.above : (distance == otherPath.distance) ?
        _eRank.same : _eRank.same);
    }

    public int _oRank (_eAny _lArg)
    {
        if (_lArg instanceof Edge)
        {
            int _lTemp = _lRank ((Edge) _lArg);
            return _lTemp == _eRank.same ?
            _lClassRank (_lArg) : _lTemp;
        }
        return super._oRank (_lArg);
    }

    public Edge (Waypoint _vstarting, Waypoint _vending)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((0.0 <= _vstarting.x) && (0.0 <= _vstarting.y)))) throw new _xPre (
                    "Edge.pd:51,18");
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
                if (!(((0.0 <= _vending.x) && (0.0 <= _vending.y)))) throw new _xPre (
                    "Edge.pd:52,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        starting = _vstarting;
        ending = _vending;
        if ((0.0 <= new Calculations ().findDistance (new Vector (_vstarting.x, _vstarting.y), new
            Vector (_vending.x, _vending.y))))
        {
            distance = new Calculations ().findDistance (new Vector (_vstarting.x, _vstarting.y),
                new Vector (_vending.x, _vending.y));
        }
        else
        {
            distance = 0.0;
        }
        direction = new Calculations ().findDirectionVector (new Vector (_vstarting.x, _vstarting.y),
            new Vector (_vending.x, _vending.y));
        _lc_Edge ("Edge.pd:64,7");
    }

    public boolean _lEqual (Edge _vArg_14_7)
    {
        if (this == _vArg_14_7)
        {
            return true;
        }
        _lClassInvariantCheck ("Edge.pd:14,7");
        return (((_vArg_14_7.starting._lEqual (starting) && _vArg_14_7.ending._lEqual (ending)) && (
            _vArg_14_7.distance == distance)) && _vArg_14_7.direction._lEqual (direction));
    }

    public boolean _oLess (Edge _vArg_14_7)
    {
        _lClassInvariantCheck ("Edge.pd:14,7");
        return (this._oRank (_vArg_14_7) == _eRank.below);
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Edge.class && _lEqual ((Edge)
            _lArg));
    }

}


// End of file.
