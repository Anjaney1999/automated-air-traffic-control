//***********************************************************************************************
//* File: 'PotentialCollision.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/PotentialCollision.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class PotentialCollision extends _eAny
{
    final void _lc_PotentialCollision (String _lArg)
    {
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((2 == airplanes._oHash ()))) throw new _xClassInvariantItem (
                    "PotentialCollision.pd:15,24", _lArg);
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
                if (!((0.0 <= time))) throw new _xClassInvariantItem ("PotentialCollision.pd:17,20",
                    _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
    }

    protected void _lClassInvariantCheck (String _lArg)
    {
        _lc_PotentialCollision (_lArg);
    }

    public _eSeq airplanes;
    public double time;
    public double minDist;
    public boolean contains (_eSeq id, char _t0id, _eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("PotentialCollision.pd:26,3");
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= 0))) throw new _xConstraint ("builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vCondResult_29_8;
        if (((_eSeq) airplanes._oIndex (0))._lEqual (id))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= 1))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            _vCondResult_29_8 = ((_eSeq) airplanes._oIndex (1))._lEqual (inputId);
        }
        else
        {
            _vCondResult_29_8 = false;
        }
        boolean _vCondResult_29_53;
        if (_vCondResult_29_8)
        {
            _vCondResult_29_53 = true;
        }
        else
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= 1))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            boolean _vCondResult_29_55;
            if (((_eSeq) airplanes._oIndex (1))._lEqual (id))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= 0))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                _vCondResult_29_55 = ((_eSeq) airplanes._oIndex (0))._lEqual (inputId);
            }
            else
            {
                _vCondResult_29_55 = false;
            }
            _vCondResult_29_53 = _vCondResult_29_55;
        }
        return (_vCondResult_29_53 ?
        true : false);
    }

    public int involves (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("PotentialCollision.pd:36,3");
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= 0))) throw new _xConstraint ("builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (((_eSeq) airplanes._oIndex (0))._lEqual (id))
        {
            return 0;
        }
        else
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= 1))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (((_eSeq) airplanes._oIndex (1))._lEqual (id))
            {
                return 1;
            }
            else
            {
                return (- 1);
            }
        }
    }

    public int _lRank (PotentialCollision otherPotentialCollision)
    {
        if (this == otherPotentialCollision)
        {
            return _eRank.same;
        }
        _lClassInvariantCheck ("PotentialCollision.pd:48,3");
        return ((time < otherPotentialCollision.time) ?
        _eRank.below : (otherPotentialCollision.time < time) ?
        _eRank.above : (time == otherPotentialCollision.time) ?
        ((minDist == otherPotentialCollision.minDist) ?
        _eRank.same : (minDist < otherPotentialCollision.minDist) ?
        _eRank.below : _eRank.above) : _eRank.same);
    }

    public int _oRank (_eAny _lArg)
    {
        if (_lArg instanceof PotentialCollision)
        {
            int _lTemp = _lRank ((PotentialCollision) _lArg);
            return _lTemp == _eRank.same ?
            _lClassRank (_lArg) : _lTemp;
        }
        return super._oRank (_lArg);
    }

    public PotentialCollision (_eSeq _vairplanes, _eSeq _t0_vairplanes, char _t1_vairplanes, double
        _vtime, double _vminDist)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= _vtime))) throw new _xPre ("PotentialCollision.pd:71,12");
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
                if (!((2 == _vairplanes._oHash ()))) throw new _xPre ("PotentialCollision.pd:72,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        airplanes = _vairplanes;
        time = _vtime;
        minDist = _vminDist;
        _lc_PotentialCollision ("PotentialCollision.pd:69,3");
    }

    public boolean _lEqual (PotentialCollision _vArg_8_9)
    {
        if (this == _vArg_8_9)
        {
            return true;
        }
        _lClassInvariantCheck ("PotentialCollision.pd:8,9");
        return ((_vArg_8_9.airplanes._lEqual (airplanes) && (_vArg_8_9.time == time)) && (_vArg_8_9.
            minDist == minDist));
    }

    public boolean _oLess (PotentialCollision _vArg_8_9)
    {
        _lClassInvariantCheck ("PotentialCollision.pd:8,9");
        return (this._oRank (_vArg_8_9) == _eRank.below);
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == PotentialCollision.class &&
            _lEqual ((PotentialCollision) _lArg));
    }

}


// End of file.
