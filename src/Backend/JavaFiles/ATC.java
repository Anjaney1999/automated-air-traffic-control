//***********************************************************************************************
//* File: 'ATC.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/ATC.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class ATC extends _eAny
{
    final void _lc_ATC (String _lArg)
    {
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= time))) throw new _xClassInvariantItem ("ATC.pd:51,20", _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
    }

    protected void _lClassInvariantCheck (String _lArg)
    {
        _lc_ATC (_lArg);
    }

    protected _eMap airplanes;
    protected _eSeq airplanesToRemove;
    protected _eMap waypoints;
    protected _eSeq potentialCollisions;
    protected _ePair regionSize;
    protected double time;
    protected _eMap newPath;
    protected _eMap distance;
    protected PriorityQueue priorityQueue;
    protected int noOfCrashes;
    protected double numAirplanesThatLeftRegion;
    protected double sumPercentageOfTimeConflicted1;
    protected double sumPercentageOfTimeConflicted2;
    protected double sumTimeConflicted;
    public boolean idIsUnique (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:56,5");
        return ((!waypoints.dom ()._ovIn (((_eAny) id))) && (!airplanes.dom ()._ovIn (((_eAny) id))))
            ;
    }

    public int getNoOfCrashes ()
    {
        _lClassInvariantCheck ("ATC.pd:59,5");
        return noOfCrashes;
    }

    public double getAverageTimeConflicted ()
    {
        _lClassInvariantCheck ("ATC.pd:61,5");
        return ((numAirplanesThatLeftRegion <= 0.0) ?
        0.0 : _eSystem._oDiv (sumTimeConflicted, numAirplanesThatLeftRegion));
    }

    public double getPercentageOfTimeConflicted1 ()
    {
        _lClassInvariantCheck ("ATC.pd:71,5");
        return ((numAirplanesThatLeftRegion <= 0.0) ?
        0.0 : _eSystem._oDiv (sumPercentageOfTimeConflicted1, numAirplanesThatLeftRegion));
    }

    public double getPercentageOfTimeConflicted2 ()
    {
        _lClassInvariantCheck ("ATC.pd:81,5");
        return ((numAirplanesThatLeftRegion <= 0.0) ?
        0.0 : _eSystem._oDiv (sumPercentageOfTimeConflicted2, numAirplanesThatLeftRegion));
    }

    public int getNumberOfAirplanes ()
    {
        _lClassInvariantCheck ("ATC.pd:94,5");
        return airplanes.dom ()._oHash ();
    }

    public int getNumberOfWaypoints ()
    {
        _lClassInvariantCheck ("ATC.pd:96,5");
        return waypoints.dom ()._oHash ();
    }

    public int getNumberOfPotentialCollisions ()
    {
        _lClassInvariantCheck ("ATC.pd:98,5");
        return potentialCollisions._oHash ();
    }

    public int getNumberOfAirplanesToRemove ()
    {
        _lClassInvariantCheck ("ATC.pd:100,5");
        return airplanesToRemove._oHash ();
    }

    public boolean isAirplaneInTrackedRegion (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:102,5");
        return airplanes.dom ()._ovIn (((_eAny) id));
    }

    public boolean isWaypointInTrackedRegion (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:105,5");
        return waypoints.dom ()._ovIn (((_eAny) id));
    }

    public _eSeq getAirplaneLocation (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:108,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        _eSystem._ltoString (((Airplane) airplanes._oIndex (((_eAny) id))).x)._oPlusPlus (_eSystem.
            _lString (","), (_eTemplate_0) null)._oPlusPlus (_eSystem._ltoString (((Airplane)
            airplanes._oIndex (((_eAny) id))).y), (_eTemplate_0) null) : _eSystem._lString ("null"));
    }

    public _eSeq getAirplaneAction (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:118,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        ((Airplane) airplanes._oIndex (((_eAny) id))).action : _eSystem._lString ("null"));
    }

    public double getAirplaneCeiling (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:128,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        ((Airplane) airplanes._oIndex (((_eAny) id))).getAirplaneCeiling () : 0.0);
    }

    public double getAirplaneFloor (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:139,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        ((Airplane) airplanes._oIndex (((_eAny) id))).getAirplaneFloor () : 0.0);
    }

    public _eSeq getAirplaneStatus (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:150,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        Status._ltoString (((Airplane) airplanes._oIndex (((_eAny) id))).status) : _eSystem._lString
            ("null"));
    }

    public double getAirplaneAltitude (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:160,5");
        return (airplanes.dom ()._ovIn (((_eAny) id)) ?
        ((Airplane) airplanes._oIndex (((_eAny) id))).z : 0.0);
    }

    public _eSeq getOrigin (_eSeq inputString, char _t0inputString)
    {
        _lClassInvariantCheck ("ATC.pd:170,5");
        return (newPath.dom ()._ovIn (((_eAny) inputString)) ?
        ((_eSeq) newPath._oIndex (((_eAny) inputString))) : _eSystem._lString ("NaN"));
    }

    public _eSeq printCollisions ()
    {
        _lClassInvariantCheck ("ATC.pd:179,5");
        return ((!(0 == potentialCollisions._oHash ())) ?
        printEachCollision (0) : _eSystem._lString ("NO COLLISIONS DETECTED"));
    }

    public _eSeq printEachCollision (int index)
    {
        _lClassInvariantCheck ("ATC.pd:190,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:192,15");
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
                if (!((index < potentialCollisions._oHash ()))) throw new _xPre ("ATC.pd:193,15");
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
                if (!((!(0 == potentialCollisions._oHash ())))) throw new _xPre ("ATC.pd:194,30");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vCondResult_199_45;
        if ((index < (potentialCollisions._oHash () - 1)))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            _vCondResult_199_45 = (2 == ((PotentialCollision) potentialCollisions._oIndex (index)).
                airplanes._oHash ());
        }
        else
        {
            _vCondResult_199_45 = false;
        }
        if (_vCondResult_199_45)
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
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
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
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
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            return _eSystem._lString ("potential collision ")._oPlusPlus (_eSystem._ltoString ((1 +
                index)), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (": ("), (_eTemplate_0)
                null)._oPlusPlus (((_eSeq) ((PotentialCollision) potentialCollisions._oIndex (index))
                .airplanes._oIndex (0)), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (", "),
                (_eTemplate_0) null)._oPlusPlus (((_eSeq) ((PotentialCollision) potentialCollisions.
                _oIndex (index)).airplanes._oIndex (1)), (_eTemplate_0) null)._oPlusPlus (_eSystem.
                _lString (") time: "), (_eTemplate_0) null)._oPlusPlus (_eSystem._ltoString (
                _eSystem.roundin ((((PotentialCollision) potentialCollisions._oIndex (index)).time +
                1))), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString ("\n"), (_eTemplate_0) null)
                ._oPlusPlus (printEachCollision ((1 + index)), (_eTemplate_0) null);
        }
        else
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if ((2 == ((PotentialCollision) potentialCollisions._oIndex (index)).airplanes._oHash ())
                )
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
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
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
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
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                return _eSystem._lString ("potential collision ")._oPlusPlus (_eSystem._ltoString ((
                    1 + index)), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (": ("), (
                    _eTemplate_0) null)._oPlusPlus (((_eSeq) ((PotentialCollision)
                    potentialCollisions._oIndex (index)).airplanes._oIndex (0)), (_eTemplate_0) null)
                    ._oPlusPlus (_eSystem._lString (", "), (_eTemplate_0) null)._oPlusPlus (((_eSeq)
                    ((PotentialCollision) potentialCollisions._oIndex (index)).airplanes._oIndex (1))
                    , (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (") time: "), (_eTemplate_0)
                    null)._oPlusPlus (_eSystem._ltoString (_eSystem.roundin ((((PotentialCollision)
                    potentialCollisions._oIndex (index)).time + 1))), (_eTemplate_0) null);
            }
            else
            {
                return _eSystem._lString ("");
            }
        }
    }

    public _eSeq printPreventiveMeasures ()
    {
        _lClassInvariantCheck ("ATC.pd:211,12");
        return ((!(0 == airplanes.dom ()._oHash ())) ?
        getEachPreventiveMeasure (airplanes.dom ().permndec (), (_eSeq) null, (char) 0, 0) :
            _eSystem._lString ("null"));
    }

    public _eSeq getEachPreventiveMeasure (_eSeq airplaneList, _eSeq _t0airplaneList, char
        _t1airplaneList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:222,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:224,15");
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
                if (!((!(0 == airplaneList._oHash ())))) throw new _xPre ("ATC.pd:225,23");
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
                if (!((index < airplaneList._oHash ()))) throw new _xPre ("ATC.pd:226,15");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vCondResult_230_38;
        if ((index < (airplaneList._oHash () - 1)))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            _vCondResult_230_38 = airplanes.dom ()._ovIn (airplaneList._oIndex (index));
        }
        else
        {
            _vCondResult_230_38 = false;
        }
        if (_vCondResult_230_38)
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            return _eSystem._lString ("Plane: ")._oPlusPlus (((_eSeq) airplaneList._oIndex (index)),
                (_eTemplate_0) null)._oPlusPlus (_eSystem._lString ("\nFloor: "), (_eTemplate_0)
                null)._oPlusPlus (_eSystem._ltoString (((Airplane) airplanes._oIndex (airplaneList.
                _oIndex (index))).preventiveMeasure.floor), (_eTemplate_0) null)._oPlusPlus (
                _eSystem._lString (" Ceiling: "), (_eTemplate_0) null)._oPlusPlus (_eSystem.
                _ltoString (((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).
                preventiveMeasure.ceiling), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (
                " Target: "), (_eTemplate_0) null)._oPlusPlus (_eSystem._ltoString (((Airplane)
                airplanes._oIndex (airplaneList._oIndex (index))).preventiveMeasure.target), (
                _eTemplate_0) null)._oPlusPlus (_eSystem._lString (" Type: "), (_eTemplate_0) null).
                _oPlusPlus (PreventiveMeasureType._ltoString (((Airplane) airplanes._oIndex (
                airplaneList._oIndex (index))).preventiveMeasure.type), (_eTemplate_0) null).
                _oPlusPlus (_eSystem._lString (" Ending: "), (_eTemplate_0) null)._oPlusPlus (
                _eSystem._ltoString (((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).
                preventiveMeasure.ending), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString ("\n"),
                (_eTemplate_0) null)._oPlusPlus (getEachPreventiveMeasure (airplaneList, (_eSeq)
                null, (char) 0, (1 + index)), (_eTemplate_0) null);
        }
        else
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (airplanes.dom ()._ovIn (airplaneList._oIndex (index)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                return _eSystem._lString ("Floor: ")._oPlusPlus (_eSystem._ltoString (((Airplane)
                    airplanes._oIndex (airplaneList._oIndex (index))).preventiveMeasure.floor), (
                    _eTemplate_0) null)._oPlusPlus (_eSystem._lString (" Ceiling: "), (_eTemplate_0)
                    null)._oPlusPlus (_eSystem._ltoString (((Airplane) airplanes._oIndex (
                    airplaneList._oIndex (index))).preventiveMeasure.ceiling), (_eTemplate_0) null).
                    _oPlusPlus (_eSystem._lString (" Target: "), (_eTemplate_0) null)._oPlusPlus (
                    _eSystem._ltoString (((Airplane) airplanes._oIndex (airplaneList._oIndex (index))
                    ).preventiveMeasure.target), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString
                    (" Type: "), (_eTemplate_0) null)._oPlusPlus (PreventiveMeasureType._ltoString (
                    ((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).preventiveMeasure.
                    type), (_eTemplate_0) null)._oPlusPlus (_eSystem._lString (" Ending: "), (
                    _eTemplate_0) null)._oPlusPlus (_eSystem._ltoString (((Airplane) airplanes.
                    _oIndex (airplaneList._oIndex (index))).preventiveMeasure.ending), (_eTemplate_0)
                    null);
            }
            else
            {
                return _eSystem._lString ("");
            }
        }
    }

    public _eSeq getWaypointLocation (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:252,5");
        return (waypoints.dom ()._ovIn (((_eAny) id)) ?
        _eSystem._ltoString (((Waypoint) waypoints._oIndex (((_eAny) id))).x)._oPlusPlus (_eSystem.
            _lString (","), (_eTemplate_0) null)._oPlusPlus (_eSystem._ltoString (((Waypoint)
            waypoints._oIndex (((_eAny) id))).y), (_eTemplate_0) null) : _eSystem._lString ("null"));
    }

    public _eSeq getCurrentPathVector (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:262,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) id)))) throw new _xPre ("ATC.pd:264,12");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return ((!(0 == ((Airplane) airplanes._oIndex (((_eAny) id))).route._oHash ())) ?
        _eSystem._ltoString (((Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.x).
            _oPlusPlus (_eSystem._lString (","), (_eTemplate_0) null)._oPlusPlus (_eSystem.
            _ltoString (((Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.y), (
            _eTemplate_0) null) : _eSystem._lString ("null"));
    }

    public boolean isValidWaypointLocation (double x, double y)
    {
        _lClassInvariantCheck ("ATC.pd:278,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((x <= ((_eWrapper_real) regionSize.x).value) && (0.0 <= x)))) throw new _xPre
                    ("ATC.pd:280,15");
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
                if (!(((y <= ((_eWrapper_real) regionSize.y).value) && (0.0 <= y)))) throw new _xPre
                    ("ATC.pd:281,15");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (((((x <= ((_eWrapper_real) regionSize.x).value) && (0.0 <= x)) && (y <= ((_eWrapper_real)
            regionSize.y).value)) && (0.0 <= y)))
        {
            boolean _vQuantifierResult_285_9;
            {
                _eSet _vCaptureBound_waypointId_286_42 = waypoints.dom ();
                _vQuantifierResult_285_9 = true;
                int _vCaptureCount_waypointId_286_42 = _vCaptureBound_waypointId_286_42._oHash ();
                int _vLoopCounter_286_20 = 0;
                for (;;)
                {
                    if (((_vLoopCounter_286_20 == _vCaptureCount_waypointId_286_42) || (!
                        _vQuantifierResult_285_9))) break;
                    _vQuantifierResult_285_9 = (10000.0 <= new Calculations ().findDistance (new
                        Vector (x, y), new Vector (((Waypoint) waypoints._oIndex (
                        _vCaptureBound_waypointId_286_42._oIndex (_vLoopCounter_286_20))).x, ((
                        Waypoint) waypoints._oIndex (_vCaptureBound_waypointId_286_42._oIndex (
                        _vLoopCounter_286_20))).y)));
                    if ((!_vQuantifierResult_285_9))
                    {
                    }
                    else
                    {
                        _vLoopCounter_286_20 = _eSystem._oSucc (_vLoopCounter_286_20);
                    }
                }
            }
            return _vQuantifierResult_285_9;
        }
        else
        {
            return false;
        }
    }

    public void addWaypoint (_eSeq id, char _t0id, double x, double y)
    {
        _lClassInvariantCheck ("ATC.pd:294,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((x <= ((_eWrapper_real) regionSize.x).value) && (0.0 <= x)))) throw new _xPre
                    ("ATC.pd:296,15");
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
                if (!(((y <= ((_eWrapper_real) regionSize.y).value) && (0.0 <= y)))) throw new _xPre
                    ("ATC.pd:297,15");
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
                if (!((!waypoints.dom ()._ovIn (((_eAny) id))))) throw new _xPre ("ATC.pd:298,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!waypoints.dom ()._ovIn (((_eAny) id))))
        {
            if (((((x < ((_eWrapper_real) regionSize.x).value) && (0.0 < x)) && (y < ((
                _eWrapper_real) regionSize.y).value)) && (0.0 < y)))
            {
                {
                    Waypoint waypoint = new Waypoint (id, (char) 0, x, y);
                    if (isValidWaypointLocation (x, y))
                    {
                        waypoints = waypoints._nr_append (((_eAny) id), (_eRtArrow) null, ((_eAny)
                            waypoint));
                    }
                    else
                    {
                    }
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:300,9");
    }

    public void addAirplane (_eSeq id, char _t0id, double speed, double startX, double startY,
        double endX, double endY, double altitude)
    {
        _lClassInvariantCheck ("ATC.pd:322,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!airplanes.dom ()._ovIn (((_eAny) id))))) throw new _xPre ("ATC.pd:325,16");
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
                if (!((170.0 <= speed))) throw new _xPre ("ATC.pd:326,19");
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
                if (!(((8000.0 <= altitude) && (altitude <= 12000.0)))) throw new _xPre (
                    "ATC.pd:327,22");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!airplanes.dom ()._ovIn (((_eAny) id))))
        {
            if (((((0.0 <= startX) && (0.0 <= startY)) && (0.0 <= endX)) && (0.0 <= endY)))
            {
                if ((((((0.0 == startX) || (startX == ((_eWrapper_real) regionSize.x).value)) || (
                    0.0 == startY)) || (startY == ((_eWrapper_real) regionSize.y).value)) && ((((0.0
                    == endX) || (endX == ((_eWrapper_real) regionSize.x).value)) || (0.0 == endY))
                    || (endY == ((_eWrapper_real) regionSize.y).value))))
                {
                    if (((170.0 <= speed) && ((8000.0 <= altitude) && (altitude <= 12000.0))))
                    {
                        {
                            Edge _vLet_path_339_33 = new Edge (new Waypoint (startX, startY), new
                                Waypoint (endX, endY));
                            Airplane airplane = new Airplane (id, (char) 0, new _eSeq (((_eAny)
                                _vLet_path_339_33)), (Edge) null, speed, altitude);
                            airplanes = airplanes._nr_append (((_eAny) id), (_eRtArrow) null, ((
                                _eAny) airplane));
                            potentialCollisions = new _eSeq ();
                            {
                                _eSet _vCaptureBound_a_346_61 = airplanes.dom ().remove (((_eAny) id)
                                    );
                                int _vCaptureCount_a_346_61 = _vCaptureBound_a_346_61._oHash ();
                                int _vLoopCounter_346_44 = 0;
                                for (;;)
                                {
                                    if ((_vLoopCounter_346_44 == _vCaptureCount_a_346_61)) break;
                                    _eMap _vUnshare_348_41 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_348_41;
                                    ((Airplane) airplanes._osIndex (_vCaptureBound_a_346_61._oIndex
                                        (_vLoopCounter_346_44))).setPreventiveMeasure (5000.0,
                                        15000.0, 0.0, PreventiveMeasureType.noChange, (
                                        PreventiveMeasureType) null, time);
                                    _vLoopCounter_346_44 = _eSystem._oSucc (_vLoopCounter_346_44);
                                }
                            }
                        }
                    }
                    else
                    {
                    }
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:329,9");
    }

    public void updateAirplanePath (_eSeq airplaneId, char _t0airplaneId, _eSeq waypointId, char
        _t0waypointId)
    {
        _lClassInvariantCheck ("ATC.pd:370,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) airplaneId)))) throw new _xPre (
                    "ATC.pd:372,24");
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
                if (!(waypoints.dom ()._ovIn (((_eAny) waypointId)))) throw new _xPre (
                    "ATC.pd:373,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!(0 == waypoints.dom ()._oHash ())))
        {
            if ((!(0 == ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oHash ())))
            {
                if (((((0.0 <= ((Edge) ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route.
                    last ()).starting.x) && (0.0 <= ((Edge) ((Airplane) airplanes._oIndex (((_eAny)
                    airplaneId))).route.last ()).starting.y)) && (0.0 <= ((Waypoint) waypoints.
                    _oIndex (((_eAny) waypointId))).x)) && (0.0 <= ((Waypoint) waypoints._oIndex (((
                    _eAny) waypointId))).y)))
                {
                    Edge _vLet_firstSection_384_29 = new Edge (((Edge) ((Airplane) airplanes._oIndex
                        (((_eAny) airplaneId))).route.last ()).starting, ((Waypoint) waypoints.
                        _oIndex (((_eAny) waypointId))));
                    Edge _vLet_secondSection_385_29 = new Edge (((Waypoint) waypoints._oIndex (((
                        _eAny) waypointId))), ((Edge) ((Airplane) airplanes._oIndex (((_eAny)
                        airplaneId))).route.last ()).ending);
                    _ePair _vLet_paths_386_29 = new _ePair (((_eAny) _vLet_firstSection_384_29), ((
                        _eAny) _vLet_secondSection_385_29));
                    _eMap _vUnshare_387_25 = ((_eMap) airplanes._lClone ());
                    airplanes = _vUnshare_387_25;
                    ((Airplane) airplanes._osIndex (((_eAny) airplaneId))).configureFinalPath (
                        _vLet_paths_386_29, (Edge) null, (Edge) null);
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:375,9");
    }

    public void deleteAirplanePath (_eSeq airplaneId, char _t0airplaneId)
    {
        _lClassInvariantCheck ("ATC.pd:400,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) airplaneId)))) throw new _xPre (
                    "ATC.pd:402,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (airplanes.dom ()._ovIn (((_eAny) airplaneId)))
        {
            if ((0 < ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oHash ()))
            {
                _eMap _vUnshare_409_21 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_409_21;
                ((Airplane) airplanes._osIndex (((_eAny) airplaneId))).resetRoute ();
                potentialCollisions = new _eSeq ();
                {
                    _eSet _vCaptureBound_a_412_45 = airplanes.dom ();
                    int _vCaptureCount_a_412_45 = _vCaptureBound_a_412_45._oHash ();
                    int _vLoopCounter_412_32 = 0;
                    for (;;)
                    {
                        if ((_vLoopCounter_412_32 == _vCaptureCount_a_412_45)) break;
                        _eMap _vUnshare_414_29 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_414_29;
                        ((Airplane) airplanes._osIndex (_vCaptureBound_a_412_45._oIndex (
                            _vLoopCounter_412_32))).setPreventiveMeasure (5000.0, 150000.0, 0.0,
                            PreventiveMeasureType.noChange, (PreventiveMeasureType) null, time);
                        _vLoopCounter_412_32 = _eSystem._oSucc (_vLoopCounter_412_32);
                    }
                }
                if ((!(0 == ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oHash ())))
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
                    _eMap _vAntiAlias_self__airplanes_421_51 = airplanes;
                    _eMap _vUnshare_421_29 = ((_eMap) airplanes._lClone ());
                    airplanes = _vUnshare_421_29;
                    ((Airplane) airplanes._osIndex (((_eAny) airplaneId))).setCurrentVelocity (new
                        Vector ((((Airplane) _vAntiAlias_self__airplanes_421_51._oIndex (((_eAny)
                        airplaneId))).speed * ((Edge) ((Airplane) _vAntiAlias_self__airplanes_421_51
                        ._oIndex (((_eAny) airplaneId))).route._oIndex (0)).direction.x), (((
                        Airplane) _vAntiAlias_self__airplanes_421_51._oIndex (((_eAny) airplaneId)))
                        .speed * ((Edge) ((Airplane) _vAntiAlias_self__airplanes_421_51._oIndex (((
                        _eAny) airplaneId))).route._oIndex (0)).direction.y)));
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:404,9");
    }

    public void updateLocation (_eSeq id, char _t0id)
    {
        _lClassInvariantCheck ("ATC.pd:437,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) id)))) throw new _xPre ("ATC.pd:439,13");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (airplanes.dom ()._ovIn (((_eAny) id)))
        {
            if ((1 == ((Airplane) airplanes._oIndex (((_eAny) id))).route._oHash ()))
            {
                if ((0.0 <= ((Airplane) airplanes._oIndex (((_eAny) id))).timeToWaypoint))
                {
                    if ((1.0 < ((Airplane) airplanes._oIndex (((_eAny) id))).timeToWaypoint))
                    {
                        double _vLet_x_454_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).x + (
                            (Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.x);
                        double _vLet_y_455_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).y + (
                            (Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.y);
                        _eMap _vAntiAlias_self__airplanes_456_47 = airplanes;
                        _eMap _vUnshare_456_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_456_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).updateTimeToWaypoint ((((
                            Airplane) _vAntiAlias_self__airplanes_456_47._oIndex (((_eAny) id))).
                            timeToWaypoint - 1.0));
                        if (((0.0 <= _vLet_x_454_37) && (0.0 <= _vLet_y_455_37)))
                        {
                            _eMap _vUnshare_459_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_459_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).setLocation (
                                _vLet_x_454_37, _vLet_y_455_37);
                        }
                        else
                        {
                        }
                        _eMap _vUnshare_463_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_463_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setExamined (false);
                    }
                    else
                    {
                        airplanesToRemove = airplanesToRemove.append (((_eAny) id));
                    }
                }
                else
                {
                    airplanesToRemove = airplanesToRemove.append (((_eAny) id));
                }
            }
            else if ((2 <= ((Airplane) airplanes._oIndex (((_eAny) id))).route._oHash ()))
            {
                if ((0.0 <= ((Airplane) airplanes._oIndex (((_eAny) id))).timeToWaypoint))
                {
                    if ((1.0 < ((Airplane) airplanes._oIndex (((_eAny) id))).timeToWaypoint))
                    {
                        double _vLet_x_479_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).x + (
                            (Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.x);
                        double _vLet_y_480_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).y + (
                            (Airplane) airplanes._oIndex (((_eAny) id))).currentVelocity.y);
                        _eMap _vAntiAlias_self__airplanes_481_47 = airplanes;
                        _eMap _vUnshare_481_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_481_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).updateTimeToWaypoint ((((
                            Airplane) _vAntiAlias_self__airplanes_481_47._oIndex (((_eAny) id))).
                            timeToWaypoint - 1.0));
                        if (((0.0 <= _vLet_x_479_37) && (0.0 <= _vLet_y_480_37)))
                        {
                            _eMap _vUnshare_484_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_484_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).setLocation (
                                _vLet_x_479_37, _vLet_y_480_37);
                        }
                        else
                        {
                        }
                        _eMap _vUnshare_488_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_488_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setExamined (false);
                    }
                    else
                    {
                        double _vLet_timeRemaining_492_37 = (1.0 - ((Airplane) airplanes._oIndex (((
                            _eAny) id))).timeToWaypoint);
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
                        double _vLet_x_493_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).
                            nextVelocity.x + ((Edge) ((Airplane) airplanes._oIndex (((_eAny) id))).
                            route._oIndex (1)).starting.x);
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
                        double _vLet_y_494_37 = (((Airplane) airplanes._oIndex (((_eAny) id))).
                            nextVelocity.y + ((Edge) ((Airplane) airplanes._oIndex (((_eAny) id))).
                            route._oIndex (1)).starting.y);
                        _eMap _vAntiAlias_self__airplanes_495_47 = airplanes;
                        _eMap _vUnshare_495_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_495_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setCurrentVelocity (((
                            Airplane) _vAntiAlias_self__airplanes_495_47._oIndex (((_eAny) id))).
                            nextVelocity);
                        _eMap _vUnshare_496_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_496_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).updateRoute ();
                        if (((0.0 <= _vLet_x_493_37) && (0.0 <= _vLet_y_494_37)))
                        {
                            _eMap _vUnshare_499_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_499_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).setLocation (
                                _vLet_x_493_37, _vLet_y_494_37);
                        }
                        else
                        {
                        }
                        if ((0.0 <= (((Airplane) airplanes._oIndex (((_eAny) id))).timeToWaypoint -
                            _vLet_timeRemaining_492_37)))
                        {
                            _eMap _vAntiAlias_self__airplanes_505_55 = airplanes;
                            _eMap _vUnshare_505_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_505_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).updateTimeToWaypoint ((((
                                Airplane) _vAntiAlias_self__airplanes_505_55._oIndex (((_eAny) id)))
                                .timeToWaypoint - _vLet_timeRemaining_492_37));
                        }
                        else
                        {
                        }
                        _eMap _vUnshare_509_33 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_509_33;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setExamined (false);
                    }
                }
                else
                {
                    airplanesToRemove = airplanesToRemove.append (((_eAny) id));
                }
            }
            else
            {
                airplanesToRemove = airplanesToRemove.append (((_eAny) id));
            }
            if ((true == isConflicted (id, (char) 0)))
            {
                _eMap _vUnshare_525_25 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_525_25;
                ((Airplane) airplanes._osIndex (((_eAny) id))).setStatus (Status.red, (Status) null);
                _eMap _vAntiAlias_self__airplanes_526_39 = airplanes;
                _eMap _vUnshare_526_25 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_526_25;
                ((Airplane) airplanes._osIndex (((_eAny) id))).setTimeConflicted ((((Airplane)
                    _vAntiAlias_self__airplanes_526_39._oIndex (((_eAny) id))).timeConflicted + 1));
            }
            else
            {
                _eMap _vUnshare_530_25 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_530_25;
                ((Airplane) airplanes._osIndex (((_eAny) id))).setStatus (Status.green, (Status)
                    null);
            }
            if ((true == isConflictedHorizontally (id, (char) 0)))
            {
                _eMap _vAntiAlias_self__airplanes_536_39 = airplanes;
                _eMap _vUnshare_536_25 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_536_25;
                ((Airplane) airplanes._osIndex (((_eAny) id))).setTimeCloseToOtherPlanes ((((
                    Airplane) _vAntiAlias_self__airplanes_536_39._oIndex (((_eAny) id))).
                    timeCloseToOtherPlanes + 1));
            }
            else
            {
            }
            _eMap _vAntiAlias_self__airplanes_542_31 = airplanes;
            _eMap _vUnshare_542_17 = ((_eMap) airplanes._lClone ());
            airplanes = _vUnshare_542_17;
            ((Airplane) airplanes._osIndex (((_eAny) id))).setTimeFlown ((((Airplane)
                _vAntiAlias_self__airplanes_542_31._oIndex (((_eAny) id))).timeFlown + 1));
            if (airplanes.dom ()._ovIn (((_eAny) id)))
            {
                if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.type ==
                    PreventiveMeasureType.descend))
                {
                    _eMap _vUnshare_549_29 = ((_eMap) airplanes._lClone ());
                    airplanes = _vUnshare_549_29;
                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAction (_eSystem._lString (
                        "descending"), (char) 0);
                    if ((time <= ((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.
                        ending))
                    {
                        if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.target
                            < ((Airplane) airplanes._oIndex (((_eAny) id))).z))
                        {
                            double _vLet_newAltitude_555_45 = (((Airplane) airplanes._oIndex (((
                                _eAny) id))).z - ((Airplane) airplanes._oIndex (((_eAny) id))).
                                verticalSpeed);
                            if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.
                                floor < _vLet_newAltitude_555_45))
                            {
                                if (((_vLet_newAltitude_555_45 <= 15000.0) && (5000.0 <=
                                    _vLet_newAltitude_555_45)))
                                {
                                    _eMap _vUnshare_561_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_561_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        _vLet_newAltitude_555_45);
                                    if ((!(((Airplane) airplanes._oIndex (((_eAny) id))).status ==
                                        Status.red)))
                                    {
                                        _eMap _vUnshare_564_61 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_564_61;
                                        ((Airplane) airplanes._osIndex (((_eAny) id))).setStatus (
                                            Status.orange, (Status) null);
                                    }
                                    else
                                    {
                                    }
                                }
                                else if ((15000.0 < _vLet_newAltitude_555_45))
                                {
                                    _eMap _vUnshare_571_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_571_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        15000.0);
                                    _eMap _vAntiAlias_self__airplanes_572_67 = airplanes;
                                    _eMap _vUnshare_572_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_572_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_572_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_572_67._oIndex (((
                                        _eAny) id))).preventiveMeasure.ceiling, ((Airplane)
                                        _vAntiAlias_self__airplanes_572_67._oIndex (((_eAny) id))).z,
                                        PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                                        time);
                                }
                                else if ((_vLet_newAltitude_555_45 < 5000.0))
                                {
                                    _eMap _vUnshare_578_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_578_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        5000.0);
                                    _eMap _vAntiAlias_self__airplanes_579_67 = airplanes;
                                    _eMap _vUnshare_579_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_579_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_579_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_579_67._oIndex (((
                                        _eAny) id))).preventiveMeasure.ceiling, ((Airplane)
                                        _vAntiAlias_self__airplanes_579_67._oIndex (((_eAny) id))).z,
                                        PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                                        time);
                                }
                                else
                                {
                                    if (((((Airplane) airplanes._oIndex (((_eAny) id))).
                                        preventiveMeasure.floor <= 15000.0) && (5000.0 <= ((Airplane)
                                        airplanes._oIndex (((_eAny) id))).preventiveMeasure.floor)))
                                    {
                                        _eMap _vAntiAlias_self__airplanes_589_75 = airplanes;
                                        _eMap _vUnshare_589_61 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_589_61;
                                        ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                            ((Airplane) _vAntiAlias_self__airplanes_589_75._oIndex (
                                            ((_eAny) id))).preventiveMeasure.floor);
                                    }
                                    else
                                    {
                                    }
                                    _eMap _vAntiAlias_self__airplanes_594_67 = airplanes;
                                    _eMap _vUnshare_594_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_594_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_594_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_594_67._oIndex (((
                                        _eAny) id))).preventiveMeasure.ceiling, ((Airplane)
                                        _vAntiAlias_self__airplanes_594_67._oIndex (((_eAny) id))).z,
                                        PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                                        time);
                                }
                            }
                            else
                            {
                                if (((((Airplane) airplanes._oIndex (((_eAny) id))).
                                    preventiveMeasure.floor <= 15000.0) && (5000.0 <= ((Airplane)
                                    airplanes._oIndex (((_eAny) id))).preventiveMeasure.floor)))
                                {
                                    _eMap _vAntiAlias_self__airplanes_605_71 = airplanes;
                                    _eMap _vUnshare_605_57 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_605_57;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (((
                                        Airplane) _vAntiAlias_self__airplanes_605_71._oIndex (((
                                        _eAny) id))).preventiveMeasure.floor);
                                }
                                else
                                {
                                    _eMap _vUnshare_608_57 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_608_57;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        5000.0);
                                }
                                _eMap _vAntiAlias_self__airplanes_610_63 = airplanes;
                                _eMap _vUnshare_610_49 = ((_eMap) airplanes._lClone ());
                                airplanes = _vUnshare_610_49;
                                ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure
                                    (((Airplane) _vAntiAlias_self__airplanes_610_63._oIndex (((_eAny)
                                    id))).z, ((Airplane) _vAntiAlias_self__airplanes_610_63._oIndex
                                    (((_eAny) id))).preventiveMeasure.ceiling, ((Airplane)
                                    _vAntiAlias_self__airplanes_610_63._oIndex (((_eAny) id))).z,
                                    PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                                    time);
                            }
                            if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.
                                ending < (time + 1)))
                            {
                                _eMap _vUnshare_618_49 = ((_eMap) airplanes._lClone ());
                                airplanes = _vUnshare_618_49;
                                ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure
                                    (5000.0, 15000.0, 0.0, PreventiveMeasureType.noChange, (
                                    PreventiveMeasureType) null, time);
                            }
                            else
                            {
                            }
                        }
                        else
                        {
                            _eMap _vUnshare_627_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_627_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure (
                                5000.0, 15000.0, 0.0, PreventiveMeasureType.noChange, (
                                PreventiveMeasureType) null, time);
                        }
                    }
                    else
                    {
                        _eMap _vUnshare_633_37 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_633_37;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure (5000.0,
                            15000.0, 0.0, PreventiveMeasureType.noChange, (PreventiveMeasureType)
                            null, time);
                    }
                }
                else if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.type ==
                    PreventiveMeasureType.elevate))
                {
                    _eMap _vUnshare_640_29 = ((_eMap) airplanes._lClone ());
                    airplanes = _vUnshare_640_29;
                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAction (_eSystem._lString (
                        "elevating"), (char) 0);
                    if ((time <= ((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.
                        ending))
                    {
                        if ((((Airplane) airplanes._oIndex (((_eAny) id))).z < ((Airplane) airplanes
                            ._oIndex (((_eAny) id))).preventiveMeasure.target))
                        {
                            double _vLet_newAltitude_646_45 = (((Airplane) airplanes._oIndex (((
                                _eAny) id))).z + ((Airplane) airplanes._oIndex (((_eAny) id))).
                                verticalSpeed);
                            if ((_vLet_newAltitude_646_45 < ((Airplane) airplanes._oIndex (((_eAny)
                                id))).preventiveMeasure.ceiling))
                            {
                                if (((_vLet_newAltitude_646_45 <= 15000.0) && (5000.0 <=
                                    _vLet_newAltitude_646_45)))
                                {
                                    _eMap _vUnshare_652_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_652_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        _vLet_newAltitude_646_45);
                                    if ((!(((Airplane) airplanes._oIndex (((_eAny) id))).status ==
                                        Status.red)))
                                    {
                                        _eMap _vUnshare_655_61 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_655_61;
                                        ((Airplane) airplanes._osIndex (((_eAny) id))).setStatus (
                                            Status.orange, (Status) null);
                                    }
                                    else
                                    {
                                    }
                                }
                                else if ((15000.0 < _vLet_newAltitude_646_45))
                                {
                                    _eMap _vUnshare_662_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_662_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        15000.0);
                                    _eMap _vAntiAlias_self__airplanes_663_67 = airplanes;
                                    _eMap _vUnshare_663_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_663_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_663_67._oIndex (((_eAny) id))).
                                        preventiveMeasure.floor, ((Airplane)
                                        _vAntiAlias_self__airplanes_663_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_663_67._oIndex (((
                                        _eAny) id))).z, PreventiveMeasureType.noChange, (
                                        PreventiveMeasureType) null, time);
                                }
                                else if ((_vLet_newAltitude_646_45 < 5000.0))
                                {
                                    _eMap _vUnshare_669_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_669_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                        5000.0);
                                    _eMap _vAntiAlias_self__airplanes_670_67 = airplanes;
                                    _eMap _vUnshare_670_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_670_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_670_67._oIndex (((_eAny) id))).
                                        preventiveMeasure.floor, ((Airplane)
                                        _vAntiAlias_self__airplanes_670_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_670_67._oIndex (((
                                        _eAny) id))).z, PreventiveMeasureType.noChange, (
                                        PreventiveMeasureType) null, time);
                                }
                                else
                                {
                                    if (((((Airplane) airplanes._oIndex (((_eAny) id))).
                                        preventiveMeasure.ceiling <= 15000.0) && (5000.0 <= ((
                                        Airplane) airplanes._oIndex (((_eAny) id))).
                                        preventiveMeasure.ceiling)))
                                    {
                                        _eMap _vAntiAlias_self__airplanes_680_75 = airplanes;
                                        _eMap _vUnshare_680_61 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_680_61;
                                        ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                            ((Airplane) _vAntiAlias_self__airplanes_680_75._oIndex (
                                            ((_eAny) id))).preventiveMeasure.ceiling);
                                    }
                                    else
                                    {
                                        _eMap _vUnshare_683_61 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_683_61;
                                        ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (
                                            15000.0);
                                    }
                                    _eMap _vAntiAlias_self__airplanes_685_67 = airplanes;
                                    _eMap _vUnshare_685_53 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_685_53;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_685_67._oIndex (((_eAny) id))).
                                        preventiveMeasure.floor, ((Airplane)
                                        _vAntiAlias_self__airplanes_685_67._oIndex (((_eAny) id))).z,
                                        ((Airplane) _vAntiAlias_self__airplanes_685_67._oIndex (((
                                        _eAny) id))).z, PreventiveMeasureType.noChange, (
                                        PreventiveMeasureType) null, time);
                                }
                            }
                            else
                            {
                                if (((((Airplane) airplanes._oIndex (((_eAny) id))).
                                    preventiveMeasure.ceiling <= 15000.0) && (5000.0 <= ((Airplane)
                                    airplanes._oIndex (((_eAny) id))).preventiveMeasure.ceiling)))
                                {
                                    _eMap _vAntiAlias_self__airplanes_696_71 = airplanes;
                                    _eMap _vUnshare_696_57 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_696_57;
                                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAltitude (((
                                        Airplane) _vAntiAlias_self__airplanes_696_71._oIndex (((
                                        _eAny) id))).preventiveMeasure.ceiling);
                                }
                                else
                                {
                                }
                                _eMap _vAntiAlias_self__airplanes_701_63 = airplanes;
                                _eMap _vUnshare_701_49 = ((_eMap) airplanes._lClone ());
                                airplanes = _vUnshare_701_49;
                                ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure
                                    (((Airplane) _vAntiAlias_self__airplanes_701_63._oIndex (((_eAny)
                                    id))).preventiveMeasure.floor, ((Airplane)
                                    _vAntiAlias_self__airplanes_701_63._oIndex (((_eAny) id))).z, ((
                                    Airplane) _vAntiAlias_self__airplanes_701_63._oIndex (((_eAny)
                                    id))).z, PreventiveMeasureType.noChange, (PreventiveMeasureType)
                                    null, time);
                            }
                            if ((((Airplane) airplanes._oIndex (((_eAny) id))).preventiveMeasure.
                                ending < (time + 1)))
                            {
                                _eMap _vUnshare_709_49 = ((_eMap) airplanes._lClone ());
                                airplanes = _vUnshare_709_49;
                                ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure
                                    (5000.0, 15000.0, 0.0, PreventiveMeasureType.noChange, (
                                    PreventiveMeasureType) null, time);
                            }
                            else
                            {
                            }
                        }
                        else
                        {
                            _eMap _vUnshare_718_41 = ((_eMap) airplanes._lClone ());
                            airplanes = _vUnshare_718_41;
                            ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure (
                                5000.0, 15000.0, 0.0, PreventiveMeasureType.noChange, (
                                PreventiveMeasureType) null, time);
                        }
                    }
                    else
                    {
                        _eMap _vUnshare_724_38 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_724_38;
                        ((Airplane) airplanes._osIndex (((_eAny) id))).setPreventiveMeasure (5000.0,
                            15000.0, 0.0, PreventiveMeasureType.noChange, (PreventiveMeasureType)
                            null, time);
                    }
                }
                else
                {
                    _eMap _vUnshare_731_29 = ((_eMap) airplanes._lClone ());
                    airplanes = _vUnshare_731_29;
                    ((Airplane) airplanes._osIndex (((_eAny) id))).setAction (_eSystem._lString (
                        "none"), (char) 0);
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:441,6");
    }

    public boolean containsEdge (_eSeq waypointId1, char _t0waypointId1, _eSeq waypointId2, char
        _t0waypointId2)
    {
        _lClassInvariantCheck ("ATC.pd:744,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(waypoints.dom ()._ovIn (((_eAny) waypointId1)))) throw new _xPre (
                    "ATC.pd:746,25");
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
                if (!(waypoints.dom ()._ovIn (((_eAny) waypointId2)))) throw new _xPre (
                    "ATC.pd:747,25");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return ((waypoints.dom ()._ovIn (((_eAny) waypointId1)) && waypoints.dom ()._ovIn (((_eAny)
            waypointId2))) ?
        ((((- 1) == ((Waypoint) waypoints._oIndex (((_eAny) waypointId1))).neighbours.findFirst (((
            _eAny) waypointId2))) && ((- 1) == ((Waypoint) waypoints._oIndex (((_eAny) waypointId1)))
            .neighbours.findFirst (((_eAny) waypointId1)))) ?
        false : true) : false);
    }

    public boolean isConflicted (_eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("ATC.pd:763,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) inputId)))) throw new _xPre ("ATC.pd:765,21");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vQuantifierResult_767_5;
        {
            _eSet _vCaptureBound_id_768_30 = airplanes.dom ();
            _vQuantifierResult_767_5 = false;
            int _vCaptureCount_id_768_30 = _vCaptureBound_id_768_30._oHash ();
            int _vLoopCounter_768_16 = 0;
            for (;;)
            {
                if (((_vLoopCounter_768_16 == _vCaptureCount_id_768_30) || _vQuantifierResult_767_5))
                    break;
                _vQuantifierResult_767_5 = (((!((_eSeq) _vCaptureBound_id_768_30._oIndex (
                    _vLoopCounter_768_16))._lEqual (inputId)) && (new Calculations ().
                    getAbsoluteValue ((((Airplane) airplanes._oIndex (_vCaptureBound_id_768_30.
                    _oIndex (_vLoopCounter_768_16))).z - ((Airplane) airplanes._oIndex (((_eAny)
                    inputId))).z)) < 300.0)) && (new Calculations ().findDistance (new Vector (((
                    Airplane) airplanes._oIndex (_vCaptureBound_id_768_30._oIndex (
                    _vLoopCounter_768_16))).x, ((Airplane) airplanes._oIndex (
                    _vCaptureBound_id_768_30._oIndex (_vLoopCounter_768_16))).y), new Vector (((
                    Airplane) airplanes._oIndex (((_eAny) inputId))).x, ((Airplane) airplanes.
                    _oIndex (((_eAny) inputId))).y)) <= 10000.0));
                if (_vQuantifierResult_767_5)
                {
                }
                else
                {
                    _vLoopCounter_768_16 = _eSystem._oSucc (_vLoopCounter_768_16);
                }
            }
        }
        return _vQuantifierResult_767_5;
    }

    public boolean isConflictedHorizontally (_eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("ATC.pd:776,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) inputId)))) throw new _xPre ("ATC.pd:778,21");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vQuantifierResult_780_5;
        {
            _eSet _vCaptureBound_id_781_30 = airplanes.dom ();
            _vQuantifierResult_780_5 = false;
            int _vCaptureCount_id_781_30 = _vCaptureBound_id_781_30._oHash ();
            int _vLoopCounter_781_16 = 0;
            for (;;)
            {
                if (((_vLoopCounter_781_16 == _vCaptureCount_id_781_30) || _vQuantifierResult_780_5))
                    break;
                _vQuantifierResult_780_5 = ((!((_eSeq) _vCaptureBound_id_781_30._oIndex (
                    _vLoopCounter_781_16))._lEqual (inputId)) && (new Calculations ().findDistance (
                    new Vector (((Airplane) airplanes._oIndex (_vCaptureBound_id_781_30._oIndex (
                    _vLoopCounter_781_16))).x, ((Airplane) airplanes._oIndex (
                    _vCaptureBound_id_781_30._oIndex (_vLoopCounter_781_16))).y), new Vector (((
                    Airplane) airplanes._oIndex (((_eAny) inputId))).x, ((Airplane) airplanes.
                    _oIndex (((_eAny) inputId))).y)) <= 10000.0));
                if (_vQuantifierResult_780_5)
                {
                }
                else
                {
                    _vLoopCounter_781_16 = _eSystem._oSucc (_vLoopCounter_781_16);
                }
            }
        }
        return _vQuantifierResult_780_5;
    }

    public boolean willCollide (_eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("ATC.pd:789,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) inputId)))) throw new _xPre ("ATC.pd:791,21");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        boolean _vQuantifierResult_793_5;
        {
            _eSet _vCaptureBound_id_794_30 = airplanes.dom ();
            _vQuantifierResult_793_5 = false;
            int _vCaptureCount_id_794_30 = _vCaptureBound_id_794_30._oHash ();
            int _vLoopCounter_794_16 = 0;
            for (;;)
            {
                if (((_vLoopCounter_794_16 == _vCaptureCount_id_794_30) || _vQuantifierResult_793_5))
                    break;
                _vQuantifierResult_793_5 = ((!((_eSeq) _vCaptureBound_id_794_30._oIndex (
                    _vLoopCounter_794_16))._lEqual (inputId)) && ((new Calculations ().
                    getAbsoluteValue ((((Airplane) airplanes._oIndex (_vCaptureBound_id_794_30.
                    _oIndex (_vLoopCounter_794_16))).z - ((Airplane) airplanes._oIndex (((_eAny)
                    inputId))).z)) <= 20.0) && (new Calculations ().findDistance (new Vector (((
                    Airplane) airplanes._oIndex (_vCaptureBound_id_794_30._oIndex (
                    _vLoopCounter_794_16))).x, ((Airplane) airplanes._oIndex (
                    _vCaptureBound_id_794_30._oIndex (_vLoopCounter_794_16))).y), new Vector (((
                    Airplane) airplanes._oIndex (((_eAny) inputId))).x, ((Airplane) airplanes.
                    _oIndex (((_eAny) inputId))).y)) <= 80.0)));
                if (_vQuantifierResult_793_5)
                {
                }
                else
                {
                    _vLoopCounter_794_16 = _eSystem._oSucc (_vLoopCounter_794_16);
                }
            }
        }
        return _vQuantifierResult_793_5;
    }

    public void trackPotentialCollisions (_eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("ATC.pd:804,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) inputId)))) throw new _xPre ("ATC.pd:806,21");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (airplanes._ovIn (((_eAny) inputId)))
        {
            if ((!(0 == ((Airplane) airplanes._oIndex (((_eAny) inputId))).route._oHash ())))
            {
                _eSet _vLet_newList_813_25 = predictCollisions (inputId, (char) 0);
                potentialCollisions = potentialCollisions._oPlusPlus (_vLet_newList_813_25.permndec
                    (), (_eTemplate_0) null);
                potentialCollisions = potentialCollisions.permndec ();
                _eMap _vUnshare_816_21 = ((_eMap) airplanes._lClone ());
                airplanes = _vUnshare_816_21;
                ((Airplane) airplanes._osIndex (((_eAny) inputId))).setExamined (true);
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:808,10");
    }

    public _eSet predictCollisions (_eSeq inputId, char _t0inputId)
    {
        _lClassInvariantCheck ("ATC.pd:828,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) inputId)))) throw new _xPre ("ATC.pd:830,21");
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
                if (!((0 < ((Airplane) airplanes._oIndex (((_eAny) inputId))).route._oHash ())))
                    throw new _xPre ("ATC.pd:831,39");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        _eSet _vForYield_833_9 = new _eSet ();
        {
            _eSet _vCaptureBound_id_834_41 = airplanes.dom ().remove (((_eAny) inputId));
            int _vCaptureCount_id_834_41 = _vCaptureBound_id_834_41._oHash ();
            int _vLoopCounter_834_23 = 0;
            for (;;)
            {
                if ((_vLoopCounter_834_23 == _vCaptureCount_id_834_41)) break;
                boolean _vCondResult_835_13;
                if (((false == ((Airplane) airplanes._oIndex (_vCaptureBound_id_834_41._oIndex (
                    _vLoopCounter_834_23))).examined) && (!((_eSeq) _vCaptureBound_id_834_41._oIndex
                    (_vLoopCounter_834_23))._lEqual (inputId))))
                {
                    boolean _vQuantifierResult_838_22;
                    {
                        _vQuantifierResult_838_22 = true;
                        int _vCaptureCount_collisions_838_41 = potentialCollisions._oHash ();
                        int _vLoopCounter_838_29 = 0;
                        for (;;)
                        {
                            if (((_vLoopCounter_838_29 == _vCaptureCount_collisions_838_41) || (!
                                _vQuantifierResult_838_22))) break;
                            _vQuantifierResult_838_22 = (false == ((PotentialCollision)
                                potentialCollisions._oIndex (_vLoopCounter_838_29)).contains (((
                                _eSeq) _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23)), (
                                char) 0, inputId, (char) 0));
                            if ((!_vQuantifierResult_838_22))
                            {
                            }
                            else
                            {
                                _vLoopCounter_838_29 = _eSystem._oSucc (_vLoopCounter_838_29);
                            }
                        }
                    }
                    if (_vQuantifierResult_838_22)
                    {
                        _ePair _vLet_pC_840_29 = new Calculations ().computeTime (new Vector (((
                            Airplane) airplanes._oIndex (_vCaptureBound_id_834_41._oIndex (
                            _vLoopCounter_834_23))).x, ((Airplane) airplanes._oIndex (
                            _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).y), ((Airplane)
                            airplanes._oIndex (_vCaptureBound_id_834_41._oIndex (
                            _vLoopCounter_834_23))).currentVelocity, new Vector (((Airplane)
                            airplanes._oIndex (((_eAny) inputId))).x, ((Airplane) airplanes._oIndex
                            (((_eAny) inputId))).y), ((Airplane) airplanes._oIndex (((_eAny) inputId)
                            )).currentVelocity, 5000.0, ((Airplane) airplanes._oIndex (
                            _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).timeToWaypoint,
                            ((Airplane) airplanes._oIndex (((_eAny) inputId))).timeToWaypoint);
                        _vCondResult_835_13 = (((0 < ((Airplane) airplanes._oIndex (
                            _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).route._oHash ()
                            ) && (false == ((Airplane) airplanes._oIndex (_vCaptureBound_id_834_41.
                            _oIndex (_vLoopCounter_834_23))).examined)) ?
                        ((0.0 <= ((_eWrapper_real) _vLet_pC_840_29.x).value) ?
                        (((((_eWrapper_real) _vLet_pC_840_29.x).value <= ((Airplane) airplanes.
                            _oIndex (_vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).
                            timeToWaypoint) && (((_eWrapper_real) _vLet_pC_840_29.x).value <= ((
                            Airplane) airplanes._oIndex (((_eAny) inputId))).timeToWaypoint)) ?
                        true : false) : false) : false);
                    }
                    else
                    {
                        _vCondResult_835_13 = false;
                    }
                }
                else
                {
                    _vCondResult_835_13 = false;
                }
                if (_vCondResult_835_13)
                {
                    _ePair _vLet_pC_869_21 = new Calculations ().computeTime (new Vector (((Airplane)
                        airplanes._oIndex (_vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23)))
                        .x, ((Airplane) airplanes._oIndex (_vCaptureBound_id_834_41._oIndex (
                        _vLoopCounter_834_23))).y), ((Airplane) airplanes._oIndex (
                        _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).currentVelocity,
                        new Vector (((Airplane) airplanes._oIndex (((_eAny) inputId))).x, ((Airplane)
                        airplanes._oIndex (((_eAny) inputId))).y), ((Airplane) airplanes._oIndex (((
                        _eAny) inputId))).currentVelocity, 5000.0, ((Airplane) airplanes._oIndex (
                        _vCaptureBound_id_834_41._oIndex (_vLoopCounter_834_23))).timeToWaypoint, ((
                        Airplane) airplanes._oIndex (((_eAny) inputId))).timeToWaypoint);
                    _vForYield_833_9 = _vForYield_833_9.append (((_eAny) new PotentialCollision (new
                        _eSeq ()._lAppend (((_eAny) inputId), _vCaptureBound_id_834_41._oIndex (
                        _vLoopCounter_834_23)), (_eSeq) null, (char) 0, (time + ((_eWrapper_real)
                        _vLet_pC_869_21.x).value), ((_eWrapper_real) _vLet_pC_869_21.y).value)));
                }
                else
                {
                }
                _vLoopCounter_834_23 = _eSystem._oSucc (_vLoopCounter_834_23);
            }
        }
        return _vForYield_833_9;
    }

    public void recurseOverPotentialCollisions (int index, int potentialCollisionListSize)
    {
        _lClassInvariantCheck ("ATC.pd:881,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == potentialCollisionListSize)))) throw new _xPre ("ATC.pd:883,40");
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
                if (!((index < potentialCollisionListSize))) throw new _xPre ("ATC.pd:884,19");
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
                if (!((0 <= index))) throw new _xPre ("ATC.pd:885,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (((index < potentialCollisionListSize) && (index < potentialCollisions._oHash ())))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if ((2 == ((PotentialCollision) potentialCollisions._oIndex (index)).airplanes._oHash ())
                )
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
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
                _eSeq _vLet_id1_894_29 = ((_eSeq) ((PotentialCollision) potentialCollisions._oIndex
                    (index)).airplanes._oIndex (0));
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
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
                _eSeq _vLet_id2_895_29 = ((_eSeq) ((PotentialCollision) potentialCollisions._oIndex
                    (index)).airplanes._oIndex (1));
                if ((airplanes.dom ()._ovIn (((_eAny) _vLet_id1_894_29)) && airplanes.dom ()._ovIn (
                    ((_eAny) _vLet_id2_895_29))))
                {
                    if (((((Airplane) airplanes._oIndex (((_eAny) _vLet_id1_894_29))).
                        preventiveMeasure.type == PreventiveMeasureType.noChange) && (((Airplane)
                        airplanes._oIndex (((_eAny) _vLet_id2_895_29))).preventiveMeasure.type ==
                        PreventiveMeasureType.noChange)))
                    {
                        if ((((Airplane) airplanes._oIndex (((_eAny) _vLet_id2_895_29))).z <= ((
                            Airplane) airplanes._oIndex (((_eAny) _vLet_id1_894_29))).z))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            if ((0.0 <= ((PotentialCollision) potentialCollisions._oIndex (index)).
                                time))
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                assignPreventiveMeasures (_vLet_id1_894_29, (char) 0,
                                    _vLet_id2_895_29, (char) 0, ((PotentialCollision)
                                    potentialCollisions._oIndex (index)).time);
                            }
                            else
                            {
                            }
                        }
                        else
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            if ((0.0 <= ((PotentialCollision) potentialCollisions._oIndex (index)).
                                time))
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                assignPreventiveMeasures (_vLet_id2_895_29, (char) 0,
                                    _vLet_id1_894_29, (char) 0, ((PotentialCollision)
                                    potentialCollisions._oIndex (index)).time);
                            }
                            else
                            {
                            }
                        }
                    }
                    else
                    {
                    }
                }
                else
                {
                }
            }
            else
            {
            }
            if ((((1 + index) < potentialCollisionListSize) && ((1 + index) < potentialCollisions.
                _oHash ())))
            {
                recurseOverPotentialCollisions ((1 + index), potentialCollisionListSize);
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:888,9");
    }

    public void assignPreventiveMeasures (_eSeq id1, char _t0id1, _eSeq id2, char _t0id2, double
        collisionTime)
    {
        _lClassInvariantCheck ("ATC.pd:943,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) id1)))) throw new _xPre ("ATC.pd:945,17");
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
                if (!(airplanes.dom ()._ovIn (((_eAny) id2)))) throw new _xPre ("ATC.pd:946,17");
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
                if (!((0.0 <= collisionTime))) throw new _xPre ("ATC.pd:947,27");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        double _vLet_verticalDistance_950_17 = new Calculations ().getAbsoluteValue ((((Airplane)
            airplanes._oIndex (((_eAny) id1))).z - ((Airplane) airplanes._oIndex (((_eAny) id2))).z))
            ;
        if ((300.0 <= _vLet_verticalDistance_950_17))
        {
            if (((0.0 <= ((Airplane) airplanes._oIndex (((_eAny) id1))).verticalSpeed) && (0.0 <= ((
                Airplane) airplanes._oIndex (((_eAny) id2))).verticalSpeed)))
            {
                double _vLet_duration_956_29 = _eSystem._oDiv ((_vLet_verticalDistance_950_17 -
                    300.0), (((Airplane) airplanes._oIndex (((_eAny) id1))).verticalSpeed + ((
                    Airplane) airplanes._oIndex (((_eAny) id2))).verticalSpeed));
                if ((0.0 <= _vLet_duration_956_29))
                {
                    double _vLet_floor_960_37 = (((Airplane) airplanes._oIndex (((_eAny) id1))).z -
                        (_vLet_duration_956_29 * ((Airplane) airplanes._oIndex (((_eAny) id1))).
                        verticalSpeed));
                    double _vLet_ceiling_961_37 = ((_vLet_duration_956_29 * ((Airplane) airplanes.
                        _oIndex (((_eAny) id2))).verticalSpeed) + ((Airplane) airplanes._oIndex (((
                        _eAny) id2))).z);
                    if ((((Airplane) airplanes._oIndex (((_eAny) id1))).preventiveMeasure.floor <=
                        _vLet_floor_960_37))
                    {
                        _eMap _vAntiAlias_self__airplanes_965_56 = airplanes;
                        _eMap _vUnshare_965_41 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_965_41;
                        ((Airplane) airplanes._osIndex (((_eAny) id1))).setPreventiveMeasure (
                            _vLet_floor_960_37, ((Airplane) _vAntiAlias_self__airplanes_965_56.
                            _oIndex (((_eAny) id1))).preventiveMeasure.ceiling, _vLet_floor_960_37,
                            PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                            collisionTime);
                    }
                    else
                    {
                    }
                    if ((_vLet_ceiling_961_37 <= ((Airplane) airplanes._oIndex (((_eAny) id2))).
                        preventiveMeasure.ceiling))
                    {
                        _eMap _vAntiAlias_self__airplanes_974_56 = airplanes;
                        _eMap _vUnshare_974_41 = ((_eMap) airplanes._lClone ());
                        airplanes = _vUnshare_974_41;
                        ((Airplane) airplanes._osIndex (((_eAny) id2))).setPreventiveMeasure (((
                            Airplane) _vAntiAlias_self__airplanes_974_56._oIndex (((_eAny) id2))).
                            preventiveMeasure.floor, _vLet_ceiling_961_37, _vLet_ceiling_961_37,
                            PreventiveMeasureType.noChange, (PreventiveMeasureType) null,
                            collisionTime);
                    }
                    else
                    {
                    }
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else if (((_vLet_verticalDistance_950_17 < 300.0) && (0.0 <= _vLet_verticalDistance_950_17)))
        {
            {
                boolean moreSpaceAbove = false;
                if ((new Calculations ().getAbsoluteValue ((((Airplane) airplanes._oIndex (((_eAny)
                    id1))).preventiveMeasure.ceiling - ((Airplane) airplanes._oIndex (((_eAny) id1)))
                    .preventiveMeasure.floor)) < new Calculations ().getAbsoluteValue ((((Airplane)
                    airplanes._oIndex (((_eAny) id2))).preventiveMeasure.ceiling - ((Airplane)
                    airplanes._oIndex (((_eAny) id2))).preventiveMeasure.floor))))
                {
                    if ((new Calculations ().getAbsoluteValue ((((Airplane) airplanes._oIndex (((
                        _eAny) id1))).preventiveMeasure.floor - ((Airplane) airplanes._oIndex (((
                        _eAny) id1))).z)) <= new Calculations ().getAbsoluteValue ((((Airplane)
                        airplanes._oIndex (((_eAny) id1))).preventiveMeasure.ceiling - ((Airplane)
                        airplanes._oIndex (((_eAny) id1))).z))))
                    {
                        moreSpaceAbove = true;
                    }
                    else
                    {
                        moreSpaceAbove = false;
                    }
                }
                else
                {
                    if ((new Calculations ().getAbsoluteValue ((((Airplane) airplanes._oIndex (((
                        _eAny) id2))).preventiveMeasure.floor - ((Airplane) airplanes._oIndex (((
                        _eAny) id2))).z)) <= new Calculations ().getAbsoluteValue ((((Airplane)
                        airplanes._oIndex (((_eAny) id2))).preventiveMeasure.ceiling - ((Airplane)
                        airplanes._oIndex (((_eAny) id2))).z))))
                    {
                        moreSpaceAbove = true;
                    }
                    else
                    {
                        moreSpaceAbove = false;
                    }
                }
                if ((true == moreSpaceAbove))
                {
                    if ((0.0 <= ((Airplane) airplanes._oIndex (((_eAny) id1))).verticalSpeed))
                    {
                        {
                            double duration = _eSystem._oDiv ((300.0 - _vLet_verticalDistance_950_17)
                                , ((Airplane) airplanes._oIndex (((_eAny) id1))).verticalSpeed);
                            if ((0.0 <= duration))
                            {
                                if ((((time + duration) <= collisionTime) && (((300.0 -
                                    _vLet_verticalDistance_950_17) + ((Airplane) airplanes._oIndex (
                                    ((_eAny) id1))).z) <= ((Airplane) airplanes._oIndex (((_eAny)
                                    id1))).preventiveMeasure.ceiling)))
                                {
                                    _eMap _vAntiAlias_self__airplanes_1028_64 = airplanes;
                                    _eMap _vUnshare_1028_49 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_1028_49;
                                    ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_1028_64._oIndex (((_eAny) id2)))
                                        .preventiveMeasure.floor, ((Airplane)
                                        _vAntiAlias_self__airplanes_1028_64._oIndex (((_eAny) id2)))
                                        .z, ((Airplane) _vAntiAlias_self__airplanes_1028_64._oIndex
                                        (((_eAny) id2))).z, PreventiveMeasureType.noChange, (
                                        PreventiveMeasureType) null, collisionTime);
                                    if ((((300.0 - _vLet_verticalDistance_950_17) + ((Airplane)
                                        airplanes._oIndex (((_eAny) id1))).z) <= ((Airplane)
                                        airplanes._oIndex (((_eAny) id1))).preventiveMeasure.ceiling)
                                        )
                                    {
                                        _eMap _vAntiAlias_self__airplanes_1034_68 = airplanes;
                                        _eMap _vUnshare_1034_53 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_1034_53;
                                        ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                            setPreventiveMeasure (((300.0 -
                                            _vLet_verticalDistance_950_17) + ((Airplane)
                                            _vAntiAlias_self__airplanes_1034_68._oIndex (((_eAny)
                                            id1))).z), ((Airplane)
                                            _vAntiAlias_self__airplanes_1034_68._oIndex (((_eAny)
                                            id1))).preventiveMeasure.ceiling, ((300.0 -
                                            _vLet_verticalDistance_950_17) + ((Airplane)
                                            _vAntiAlias_self__airplanes_1034_68._oIndex (((_eAny)
                                            id1))).z), PreventiveMeasureType.elevate, (
                                            PreventiveMeasureType) null, collisionTime);
                                    }
                                    else
                                    {
                                        _eMap _vAntiAlias_self__airplanes_1040_68 = airplanes;
                                        _eMap _vUnshare_1040_53 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_1040_53;
                                        ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                            setPreventiveMeasure (((Airplane)
                                            _vAntiAlias_self__airplanes_1040_68._oIndex (((_eAny)
                                            id1))).preventiveMeasure.ceiling, ((Airplane)
                                            _vAntiAlias_self__airplanes_1040_68._oIndex (((_eAny)
                                            id1))).preventiveMeasure.ceiling, ((300.0 -
                                            _vLet_verticalDistance_950_17) + ((Airplane)
                                            _vAntiAlias_self__airplanes_1040_68._oIndex (((_eAny)
                                            id1))).z), PreventiveMeasureType.elevate, (
                                            PreventiveMeasureType) null, collisionTime);
                                    }
                                }
                                else
                                {
                                    duration = _eSystem._oDiv ((300.0 +
                                        _vLet_verticalDistance_950_17), ((Airplane) airplanes.
                                        _oIndex (((_eAny) id2))).verticalSpeed);
                                    if ((0.0 <= duration))
                                    {
                                        if ((((time + duration) <= collisionTime) && (((300.0 +
                                            _vLet_verticalDistance_950_17) + ((Airplane) airplanes.
                                            _oIndex (((_eAny) id2))).z) <= ((Airplane) airplanes.
                                            _oIndex (((_eAny) id2))).preventiveMeasure.ceiling)))
                                        {
                                            _eMap _vAntiAlias_self__airplanes_1055_76 = airplanes;
                                            _eMap _vUnshare_1055_61 = ((_eMap) airplanes._lClone ());
                                            airplanes = _vUnshare_1055_61;
                                            ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                setPreventiveMeasure (((Airplane)
                                                _vAntiAlias_self__airplanes_1055_76._oIndex (((_eAny)
                                                id1))).preventiveMeasure.floor, ((Airplane)
                                                _vAntiAlias_self__airplanes_1055_76._oIndex (((_eAny)
                                                id1))).z, ((Airplane)
                                                _vAntiAlias_self__airplanes_1055_76._oIndex (((_eAny)
                                                id1))).z, PreventiveMeasureType.noChange, (
                                                PreventiveMeasureType) null, collisionTime);
                                            if ((((300.0 + _vLet_verticalDistance_950_17) + ((
                                                Airplane) airplanes._oIndex (((_eAny) id2))).z) <= (
                                                (Airplane) airplanes._oIndex (((_eAny) id2))).
                                                preventiveMeasure.ceiling))
                                            {
                                                _eMap _vAntiAlias_self__airplanes_1061_80 =
                                                    airplanes;
                                                _eMap _vUnshare_1061_65 = ((_eMap) airplanes._lClone
                                                    ());
                                                airplanes = _vUnshare_1061_65;
                                                ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                    setPreventiveMeasure (((300.0 +
                                                    _vLet_verticalDistance_950_17) + ((Airplane)
                                                    _vAntiAlias_self__airplanes_1061_80._oIndex (((
                                                    _eAny) id2))).z), ((Airplane)
                                                    _vAntiAlias_self__airplanes_1061_80._oIndex (((
                                                    _eAny) id2))).preventiveMeasure.ceiling, ((300.0
                                                    + _vLet_verticalDistance_950_17) + ((Airplane)
                                                    _vAntiAlias_self__airplanes_1061_80._oIndex (((
                                                    _eAny) id2))).z), PreventiveMeasureType.elevate,
                                                    (PreventiveMeasureType) null, collisionTime);
                                            }
                                            else
                                            {
                                                _eMap _vAntiAlias_self__airplanes_1067_80 =
                                                    airplanes;
                                                _eMap _vUnshare_1067_65 = ((_eMap) airplanes._lClone
                                                    ());
                                                airplanes = _vUnshare_1067_65;
                                                ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                    setPreventiveMeasure (((Airplane)
                                                    _vAntiAlias_self__airplanes_1067_80._oIndex (((
                                                    _eAny) id2))).preventiveMeasure.ceiling, ((
                                                    Airplane) _vAntiAlias_self__airplanes_1067_80.
                                                    _oIndex (((_eAny) id2))).preventiveMeasure.
                                                    ceiling, ((300.0 + _vLet_verticalDistance_950_17)
                                                    + ((Airplane)
                                                    _vAntiAlias_self__airplanes_1067_80._oIndex (((
                                                    _eAny) id2))).z), PreventiveMeasureType.elevate,
                                                    (PreventiveMeasureType) null, collisionTime);
                                            }
                                        }
                                        else
                                        {
                                            duration = _eSystem._oDiv ((300.0 -
                                                _vLet_verticalDistance_950_17), (((Airplane)
                                                airplanes._oIndex (((_eAny) id1))).verticalSpeed + (
                                                (Airplane) airplanes._oIndex (((_eAny) id2))).
                                                verticalSpeed));
                                            if ((0.0 <= duration))
                                            {
                                                if ((((duration * ((Airplane) airplanes._oIndex (((
                                                    _eAny) id1))).verticalSpeed) + ((Airplane)
                                                    airplanes._oIndex (((_eAny) id1))).z) <= ((
                                                    Airplane) airplanes._oIndex (((_eAny) id1))).
                                                    preventiveMeasure.ceiling))
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1081_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1081_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1081_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                        setPreventiveMeasure (((duration * ((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1081_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1081_88._oIndex
                                                        (((_eAny) id1))).z), ((Airplane)
                                                        _vAntiAlias_self__airplanes_1081_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1081_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1081_88._oIndex
                                                        (((_eAny) id1))).z), PreventiveMeasureType.
                                                        elevate, (PreventiveMeasureType) null,
                                                        collisionTime);
                                                }
                                                else
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1087_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1087_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1087_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1087_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((Airplane)
                                                        _vAntiAlias_self__airplanes_1087_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1087_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1087_88._oIndex
                                                        (((_eAny) id1))).z), PreventiveMeasureType.
                                                        elevate, (PreventiveMeasureType) null,
                                                        collisionTime);
                                                }
                                                if ((((Airplane) airplanes._oIndex (((_eAny) id2))).
                                                    preventiveMeasure.floor <= (((Airplane)
                                                    airplanes._oIndex (((_eAny) id2))).z - (duration
                                                    * ((Airplane) airplanes._oIndex (((_eAny) id2)))
                                                    .verticalSpeed))))
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1095_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1095_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1095_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1095_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        (Airplane)
                                                        _vAntiAlias_self__airplanes_1095_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1095_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)), (((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1095_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1095_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)),
                                                        PreventiveMeasureType.descend, (
                                                        PreventiveMeasureType) null, collisionTime);
                                                }
                                                else
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1101_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1101_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1101_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1101_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1101_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        (Airplane)
                                                        _vAntiAlias_self__airplanes_1101_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1101_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)),
                                                        PreventiveMeasureType.descend, (
                                                        PreventiveMeasureType) null, collisionTime);
                                                }
                                            }
                                            else
                                            {
                                            }
                                        }
                                    }
                                    else
                                    {
                                    }
                                }
                            }
                            else
                            {
                            }
                        }
                    }
                    else
                    {
                    }
                }
                else if ((false == moreSpaceAbove))
                {
                    if ((0.0 <= ((Airplane) airplanes._oIndex (((_eAny) id2))).verticalSpeed))
                    {
                        {
                            double duration = _eSystem._oDiv ((300.0 - _vLet_verticalDistance_950_17)
                                , ((Airplane) airplanes._oIndex (((_eAny) id2))).verticalSpeed);
                            if ((0.0 <= duration))
                            {
                                if ((((time + duration) <= collisionTime) && (((Airplane) airplanes.
                                    _oIndex (((_eAny) id2))).preventiveMeasure.floor <= (((Airplane)
                                    airplanes._oIndex (((_eAny) id2))).z - (300.0 -
                                    _vLet_verticalDistance_950_17)))))
                                {
                                    _eMap _vAntiAlias_self__airplanes_1136_64 = airplanes;
                                    _eMap _vUnshare_1136_49 = ((_eMap) airplanes._lClone ());
                                    airplanes = _vUnshare_1136_49;
                                    ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                        setPreventiveMeasure (((Airplane)
                                        _vAntiAlias_self__airplanes_1136_64._oIndex (((_eAny) id1)))
                                        .z, ((Airplane) _vAntiAlias_self__airplanes_1136_64._oIndex
                                        (((_eAny) id1))).preventiveMeasure.ceiling, ((Airplane)
                                        _vAntiAlias_self__airplanes_1136_64._oIndex (((_eAny) id1)))
                                        .z, PreventiveMeasureType.noChange, (PreventiveMeasureType)
                                        null, collisionTime);
                                    if ((((Airplane) airplanes._oIndex (((_eAny) id2))).
                                        preventiveMeasure.floor <= (((Airplane) airplanes._oIndex ((
                                        (_eAny) id2))).z - (300.0 - _vLet_verticalDistance_950_17))))
                                    {
                                        _eMap _vAntiAlias_self__airplanes_1143_68 = airplanes;
                                        _eMap _vUnshare_1143_53 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_1143_53;
                                        ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                            setPreventiveMeasure (((Airplane)
                                            _vAntiAlias_self__airplanes_1143_68._oIndex (((_eAny)
                                            id2))).preventiveMeasure.floor, (((Airplane)
                                            _vAntiAlias_self__airplanes_1143_68._oIndex (((_eAny)
                                            id2))).z - (300.0 - _vLet_verticalDistance_950_17)), (((
                                            Airplane) _vAntiAlias_self__airplanes_1143_68._oIndex ((
                                            (_eAny) id2))).z - (300.0 -
                                            _vLet_verticalDistance_950_17)), PreventiveMeasureType.
                                            descend, (PreventiveMeasureType) null, collisionTime);
                                    }
                                    else
                                    {
                                        _eMap _vAntiAlias_self__airplanes_1149_68 = airplanes;
                                        _eMap _vUnshare_1149_53 = ((_eMap) airplanes._lClone ());
                                        airplanes = _vUnshare_1149_53;
                                        ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                            setPreventiveMeasure (((Airplane)
                                            _vAntiAlias_self__airplanes_1149_68._oIndex (((_eAny)
                                            id2))).preventiveMeasure.floor, ((Airplane)
                                            _vAntiAlias_self__airplanes_1149_68._oIndex (((_eAny)
                                            id2))).preventiveMeasure.floor, (((Airplane)
                                            _vAntiAlias_self__airplanes_1149_68._oIndex (((_eAny)
                                            id2))).z - (300.0 - _vLet_verticalDistance_950_17)),
                                            PreventiveMeasureType.descend, (PreventiveMeasureType)
                                            null, collisionTime);
                                    }
                                }
                                else
                                {
                                    duration = _eSystem._oDiv ((300.0 +
                                        _vLet_verticalDistance_950_17), ((Airplane) airplanes.
                                        _oIndex (((_eAny) id1))).verticalSpeed);
                                    if ((0.0 <= duration))
                                    {
                                        if ((((time + duration) <= collisionTime) && (((Airplane)
                                            airplanes._oIndex (((_eAny) id1))).preventiveMeasure.
                                            floor <= (((Airplane) airplanes._oIndex (((_eAny) id1)))
                                            .z - (300.0 + _vLet_verticalDistance_950_17)))))
                                        {
                                            _eMap _vAntiAlias_self__airplanes_1168_76 = airplanes;
                                            _eMap _vUnshare_1168_61 = ((_eMap) airplanes._lClone ());
                                            airplanes = _vUnshare_1168_61;
                                            ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                setPreventiveMeasure (((Airplane)
                                                _vAntiAlias_self__airplanes_1168_76._oIndex (((_eAny)
                                                id2))).z, ((Airplane)
                                                _vAntiAlias_self__airplanes_1168_76._oIndex (((_eAny)
                                                id2))).preventiveMeasure.ceiling, ((Airplane)
                                                _vAntiAlias_self__airplanes_1168_76._oIndex (((_eAny)
                                                id2))).z, PreventiveMeasureType.noChange, (
                                                PreventiveMeasureType) null, collisionTime);
                                            if ((((Airplane) airplanes._oIndex (((_eAny) id1))).
                                                preventiveMeasure.floor <= (((Airplane) airplanes.
                                                _oIndex (((_eAny) id1))).z - (300.0 +
                                                _vLet_verticalDistance_950_17))))
                                            {
                                                _eMap _vAntiAlias_self__airplanes_1175_80 =
                                                    airplanes;
                                                _eMap _vUnshare_1175_65 = ((_eMap) airplanes._lClone
                                                    ());
                                                airplanes = _vUnshare_1175_65;
                                                ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                    setPreventiveMeasure (((Airplane)
                                                    _vAntiAlias_self__airplanes_1175_80._oIndex (((
                                                    _eAny) id1))).preventiveMeasure.floor, (((
                                                    Airplane) _vAntiAlias_self__airplanes_1175_80.
                                                    _oIndex (((_eAny) id1))).z - (300.0 +
                                                    _vLet_verticalDistance_950_17)), (((Airplane)
                                                    _vAntiAlias_self__airplanes_1175_80._oIndex (((
                                                    _eAny) id1))).z - (300.0 +
                                                    _vLet_verticalDistance_950_17)),
                                                    PreventiveMeasureType.descend, (
                                                    PreventiveMeasureType) null, collisionTime);
                                            }
                                            else
                                            {
                                                _eMap _vAntiAlias_self__airplanes_1181_80 =
                                                    airplanes;
                                                _eMap _vUnshare_1181_65 = ((_eMap) airplanes._lClone
                                                    ());
                                                airplanes = _vUnshare_1181_65;
                                                ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                    setPreventiveMeasure (((Airplane)
                                                    _vAntiAlias_self__airplanes_1181_80._oIndex (((
                                                    _eAny) id1))).preventiveMeasure.floor, ((
                                                    Airplane) _vAntiAlias_self__airplanes_1181_80.
                                                    _oIndex (((_eAny) id1))).preventiveMeasure.floor,
                                                    (((Airplane) _vAntiAlias_self__airplanes_1181_80
                                                    ._oIndex (((_eAny) id1))).z - (300.0 +
                                                    _vLet_verticalDistance_950_17)),
                                                    PreventiveMeasureType.descend, (
                                                    PreventiveMeasureType) null, collisionTime);
                                            }
                                        }
                                        else
                                        {
                                            duration = _eSystem._oDiv ((300.0 -
                                                _vLet_verticalDistance_950_17), (((Airplane)
                                                airplanes._oIndex (((_eAny) id1))).verticalSpeed + (
                                                (Airplane) airplanes._oIndex (((_eAny) id2))).
                                                verticalSpeed));
                                            if ((0.0 <= duration))
                                            {
                                                if ((((duration * ((Airplane) airplanes._oIndex (((
                                                    _eAny) id1))).verticalSpeed) + ((Airplane)
                                                    airplanes._oIndex (((_eAny) id1))).z) <= ((
                                                    Airplane) airplanes._oIndex (((_eAny) id1))).
                                                    preventiveMeasure.ceiling))
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1199_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1199_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1199_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                        setPreventiveMeasure (((duration * ((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1199_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1199_88._oIndex
                                                        (((_eAny) id1))).z), ((Airplane)
                                                        _vAntiAlias_self__airplanes_1199_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1199_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1199_88._oIndex
                                                        (((_eAny) id1))).z), PreventiveMeasureType.
                                                        elevate, (PreventiveMeasureType) null,
                                                        collisionTime);
                                                }
                                                else
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1205_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1205_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1205_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id1))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1205_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((Airplane)
                                                        _vAntiAlias_self__airplanes_1205_88._oIndex
                                                        (((_eAny) id1))).preventiveMeasure.ceiling,
                                                        ((duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1205_88._oIndex
                                                        (((_eAny) id1))).verticalSpeed) + ((Airplane)
                                                        _vAntiAlias_self__airplanes_1205_88._oIndex
                                                        (((_eAny) id1))).z), PreventiveMeasureType.
                                                        elevate, (PreventiveMeasureType) null,
                                                        collisionTime);
                                                }
                                                if ((((Airplane) airplanes._oIndex (((_eAny) id2))).
                                                    preventiveMeasure.floor <= (((Airplane)
                                                    airplanes._oIndex (((_eAny) id2))).z - (duration
                                                    * ((Airplane) airplanes._oIndex (((_eAny) id2)))
                                                    .verticalSpeed))))
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1213_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1213_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1213_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1213_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        (Airplane)
                                                        _vAntiAlias_self__airplanes_1213_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1213_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)), (((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1213_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1213_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)),
                                                        PreventiveMeasureType.descend, (
                                                        PreventiveMeasureType) null, collisionTime);
                                                }
                                                else
                                                {
                                                    _eMap _vAntiAlias_self__airplanes_1219_88 =
                                                        airplanes;
                                                    _eMap _vUnshare_1219_73 = ((_eMap) airplanes.
                                                        _lClone ());
                                                    airplanes = _vUnshare_1219_73;
                                                    ((Airplane) airplanes._osIndex (((_eAny) id2))).
                                                        setPreventiveMeasure (((Airplane)
                                                        _vAntiAlias_self__airplanes_1219_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        Airplane)
                                                        _vAntiAlias_self__airplanes_1219_88._oIndex
                                                        (((_eAny) id2))).preventiveMeasure.floor, ((
                                                        (Airplane)
                                                        _vAntiAlias_self__airplanes_1219_88._oIndex
                                                        (((_eAny) id2))).z - (duration * ((Airplane)
                                                        _vAntiAlias_self__airplanes_1219_88._oIndex
                                                        (((_eAny) id2))).verticalSpeed)),
                                                        PreventiveMeasureType.descend, (
                                                        PreventiveMeasureType) null, collisionTime);
                                                }
                                            }
                                            else
                                            {
                                            }
                                        }
                                    }
                                    else
                                    {
                                    }
                                }
                            }
                            else
                            {
                            }
                        }
                    }
                    else
                    {
                    }
                }
                else throw new _xNoChoice ("ATC.pd:1124,41");
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:949,9");
    }

    public void addPermissibleEdge (_eSeq waypointId1, char _t0waypointId1, _eSeq waypointId2, char
        _t0waypointId2)
    {
        _lClassInvariantCheck ("ATC.pd:1250,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((waypoints.dom ()._ovIn (((_eAny) waypointId1)) && waypoints.dom ()._ovIn (((
                    _eAny) waypointId2))))) throw new _xPre ("ATC.pd:1252,25");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((waypoints.dom ()._ovIn (((_eAny) waypointId1)) && waypoints.dom ()._ovIn (((_eAny)
            waypointId2))))
        {
            if ((((- 1) == ((Waypoint) waypoints._oIndex (((_eAny) waypointId1))).neighbours.
                findFirst (((_eAny) waypointId2))) && ((- 1) == ((Waypoint) waypoints._oIndex (((
                _eAny) waypointId1))).neighbours.findFirst (((_eAny) waypointId1)))))
            {
                _eMap _vUnshare_1261_25 = ((_eMap) waypoints._lClone ());
                waypoints = _vUnshare_1261_25;
                ((Waypoint) waypoints._osIndex (((_eAny) waypointId1))).addNeighbour (waypointId2, (
                    char) 0);
                _eMap _vUnshare_1262_25 = ((_eMap) waypoints._lClone ());
                waypoints = _vUnshare_1262_25;
                ((Waypoint) waypoints._osIndex (((_eAny) waypointId2))).addNeighbour (waypointId1, (
                    char) 0);
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1254,9");
    }

    public void iterateThroughNeighbours (_eSeq waypointId, char _t0waypointId, int index, double
        dist)
    {
        _lClassInvariantCheck ("ATC.pd:1274,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(waypoints.dom ()._ovIn (((_eAny) waypointId)))) throw new _xPre (
                    "ATC.pd:1276,24");
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
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1277,19");
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
                if (!((index < ((Waypoint) waypoints._oIndex (((_eAny) waypointId))).neighbours.
                    _oHash ()))) throw new _xPre ("ATC.pd:1278,19");
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
                if (!((0.0 <= dist))) throw new _xPre ("ATC.pd:1279,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        Waypoint _vLet_currentWaypoint_1283_17 = ((Waypoint) waypoints._oIndex (((_eAny) waypointId))
            );
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (waypoints.dom ()._ovIn (_vLet_currentWaypoint_1283_17.neighbours._oIndex (index)))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            double _vLet_alt_1287_25 = (dist + new Edge (((Waypoint) waypoints._oIndex (
                _vLet_currentWaypoint_1283_17.neighbours._oIndex (index))),
                _vLet_currentWaypoint_1283_17).distance);
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (distance._ovIn (_vLet_currentWaypoint_1283_17.neighbours._oIndex (index)))
            {
                {
                    boolean _vCondResult_1291_41;
                    if ((0.0 <= _vLet_alt_1287_25))
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _vCondResult_1291_41 = (_vLet_alt_1287_25 < ((_eWrapper_real) distance.
                            _oIndex (_vLet_currentWaypoint_1283_17.neighbours._oIndex (index))).
                            value);
                    }
                    else
                    {
                        _vCondResult_1291_41 = false;
                    }
                    if (_vCondResult_1291_41)
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _eMap _vUnshare_1293_33 = ((_eMap) distance._lClone ());
                        distance = _vUnshare_1293_33;
                        _vUnshare_1293_33._oaIndex (_vLet_currentWaypoint_1283_17.neighbours._oIndex
                            (index), ((_eAny) new _eWrapper_real (_vLet_alt_1287_25)));
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        if (newPath.dom ()._ovIn (_vLet_currentWaypoint_1283_17.neighbours._oIndex (
                            index)))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            _eMap _vUnshare_1296_41 = ((_eMap) newPath._lClone ());
                            newPath = _vUnshare_1296_41;
                            _vUnshare_1296_41._oaIndex (_vLet_currentWaypoint_1283_17.neighbours.
                                _oIndex (index), ((_eAny) waypointId));
                        }
                        else
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            newPath = newPath._nr_append (_vLet_currentWaypoint_1283_17.neighbours.
                                _oIndex (index), (_eRtArrow) null, ((_eAny) waypointId));
                        }
                        if ((!(0 == priorityQueue.size ())))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            PriorityQueue _vUnshare_1302_41 = ((PriorityQueue) priorityQueue._lClone
                                ());
                            priorityQueue = _vUnshare_1302_41;
                            priorityQueue.updateNode (((_eSeq) _vLet_currentWaypoint_1283_17.
                                neighbours._oIndex (index)), (char) 0, _vLet_alt_1287_25);
                        }
                        else
                        {
                        }
                    }
                    else
                    {
                    }
                }
            }
            else
            {
            }
        }
        else
        {
        }
        if (((1 + index) < ((Waypoint) waypoints._oIndex (((_eAny) waypointId))).neighbours._oHash ()
            ))
        {
            iterateThroughNeighbours (waypointId, (char) 0, (1 + index), dist);
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1282,9");
    }

    public void iterateThroughPriorityQueue (int size)
    {
        _lClassInvariantCheck ("ATC.pd:1326,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 < priorityQueue.size ()))) throw new _xPre ("ATC.pd:1328,32");
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
                if (!((size <= priorityQueue.size ()))) throw new _xPre ("ATC.pd:1329,18");
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
                if (!((0 <= size))) throw new _xPre ("ATC.pd:1330,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!(0 == priorityQueue.size ())))
        {
            Node _vLet_u_1336_21 = priorityQueue.getMin ();
            PriorityQueue _vUnshare_1338_21 = ((PriorityQueue) priorityQueue._lClone ());
            priorityQueue = _vUnshare_1338_21;
            priorityQueue.removeMin ();
            if ((waypoints.dom ()._ovIn (((_eAny) _vLet_u_1336_21.waypoint)) && (0.0 <=
                _vLet_u_1336_21.distance)))
            {
                if ((!(0 == ((Waypoint) waypoints._oIndex (((_eAny) _vLet_u_1336_21.waypoint))).
                    neighbours._oHash ())))
                {
                    iterateThroughNeighbours (_vLet_u_1336_21.waypoint, (char) 0, 0, _vLet_u_1336_21
                        .distance);
                }
                else
                {
                }
            }
            else
            {
            }
            if ((((0 <= (size - 1)) && (!(0 == priorityQueue.size ()))) && ((size - 1) <=
                priorityQueue.size ())))
            {
                iterateThroughPriorityQueue ((size - 1));
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1333,9");
    }

    public void initializePriorityQueue (_eSeq waypointList, _eSeq _t0waypointList, char
        _t1waypointList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1367,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == waypointList._oHash ())))) throw new _xPre ("ATC.pd:1369,27");
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
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1370,19");
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
                if (!((index < waypointList._oHash ()))) throw new _xPre ("ATC.pd:1371,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            boolean _vCondResult_1376_50;
            if ((!_eSystem._lString ("source")._lEqual (((_eSeq) waypointList._oIndex (index)))))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                _vCondResult_1376_50 = (!_eSystem._lString ("target")._lEqual (((_eSeq) waypointList
                    ._oIndex (index))));
            }
            else
            {
                _vCondResult_1376_50 = false;
            }
            if (_vCondResult_1376_50)
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                PriorityQueue _vUnshare_1378_21 = ((PriorityQueue) priorityQueue._lClone ());
                priorityQueue = _vUnshare_1378_21;
                priorityQueue.insert (new Node (((_eSeq) waypointList._oIndex (index)), (char) 0,
                    1e+006));
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if ((!distance._ovIn (waypointList._oIndex (index))))
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    distance = distance._nr_append (waypointList._oIndex (index), (_eRtArrow) null,
                        ((_eAny) new _eWrapper_real (1e+006)));
                }
                else
                {
                }
            }
            else
            {
            }
        }
        if (((1 + index) < waypointList._oHash ()))
        {
            initializePriorityQueue (waypointList, (_eSeq) null, (char) 0, (1 + index));
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1374,9");
    }

    public void dijkstras ()
    {
        _lClassInvariantCheck ("ATC.pd:1399,20");
        Node _vLet_sourceNode_1402_17 = new Node (_eSystem._lString ("source"), (char) 0, 0.0);
        Node _vLet_targetNode_1403_17 = new Node (_eSystem._lString ("target"), (char) 0, 1e+006);
        _eSeq _vLet_waypointList_1404_17 = waypoints.dom ().permndec ();
        PriorityQueue _vUnshare_1406_17 = ((PriorityQueue) priorityQueue._lClone ());
        priorityQueue = _vUnshare_1406_17;
        priorityQueue.insert (_vLet_sourceNode_1402_17);
        PriorityQueue _vUnshare_1407_17 = ((PriorityQueue) priorityQueue._lClone ());
        priorityQueue = _vUnshare_1407_17;
        priorityQueue.insert (_vLet_targetNode_1403_17);
        if (((!distance.dom ()._ovIn (((_eAny) _eSystem._lString ("source")))) && (!distance.dom ().
            _ovIn (((_eAny) _eSystem._lString ("target"))))))
        {
            distance = distance._nr_append (((_eAny) _eSystem._lString ("source")), (_eRtArrow) null,
                ((_eAny) new _eWrapper_real (0.0)));
            distance = distance._nr_append (((_eAny) _eSystem._lString ("target")), (_eRtArrow) null,
                ((_eAny) new _eWrapper_real (1e+006)));
        }
        else
        {
        }
        if ((!(0 == _vLet_waypointList_1404_17._oHash ())))
        {
            initializePriorityQueue (_vLet_waypointList_1404_17, (_eSeq) null, (char) 0, 0);
        }
        else
        {
        }
        if ((!(0 == priorityQueue.size ())))
        {
            iterateThroughPriorityQueue (priorityQueue.size ());
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1401,9");
    }

    public void addNeighbours (_eSeq currentWaypoint, char _t0currentWaypoint, _eSeq waypointList,
        _eSeq _t0waypointList, char _t1waypointList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1435,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1437,19");
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
                if (!(waypoints.dom ()._ovIn (((_eAny) currentWaypoint)))) throw new _xPre (
                    "ATC.pd:1438,29");
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
                if (!((index < waypointList._oHash ()))) throw new _xPre ("ATC.pd:1439,19");
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
                if (!((!(0 == waypointList._oHash ())))) throw new _xPre ("ATC.pd:1440,27");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            boolean _vCondResult_1445_50;
            if ((!_eSystem._lString ("source")._lEqual (((_eSeq) waypointList._oIndex (index)))))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                _vCondResult_1445_50 = (!_eSystem._lString ("target")._lEqual (((_eSeq) waypointList
                    ._oIndex (index))));
            }
            else
            {
                _vCondResult_1445_50 = false;
            }
            if (_vCondResult_1445_50)
            {
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    boolean _vCondResult_1447_59;
                    if (waypoints.dom ()._ovIn (waypointList._oIndex (index)))
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _vCondResult_1447_59 = (!((_eSeq) waypointList._oIndex (index))._lEqual (
                            currentWaypoint));
                    }
                    else
                    {
                        _vCondResult_1447_59 = false;
                    }
                    if (_vCondResult_1447_59)
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _eMap _vUnshare_1449_25 = ((_eMap) waypoints._lClone ());
                        waypoints = _vUnshare_1449_25;
                        ((Waypoint) waypoints._osIndex (((_eAny) currentWaypoint))).addNeighbour (((
                            _eSeq) waypointList._oIndex (index)), (char) 0);
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _eMap _vUnshare_1450_25 = ((_eMap) waypoints._lClone ());
                        waypoints = _vUnshare_1450_25;
                        ((Waypoint) waypoints._osIndex (waypointList._oIndex (index))).addNeighbour
                            (currentWaypoint, (char) 0);
                    }
                    else
                    {
                    }
                }
            }
            else
            {
            }
        }
        if (((1 + index) < waypointList._oHash ()))
        {
            addNeighbours (currentWaypoint, (char) 0, waypointList, (_eSeq) null, (char) 0, (1 +
                index));
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1443,9");
    }

    public void connectIsolatedWaypoints (_eSeq waypointList, _eSeq _t0waypointList, char
        _t1waypointList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1467,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1469,19");
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
                if (!((!(0 == waypointList._oHash ())))) throw new _xPre ("ATC.pd:1470,27");
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
                if (!((index < waypointList._oHash ()))) throw new _xPre ("ATC.pd:1471,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (waypoints.dom ()._ovIn (waypointList._oIndex (index)))
        {
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                boolean _vCondResult_1478_54;
                if ((!_eSystem._lString ("source")._lEqual (((_eSeq) waypointList._oIndex (index)))))
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    _vCondResult_1478_54 = (!_eSystem._lString ("target")._lEqual (((_eSeq)
                        waypointList._oIndex (index))));
                }
                else
                {
                    _vCondResult_1478_54 = false;
                }
                if (_vCondResult_1478_54)
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    if ((0 == ((Waypoint) waypoints._oIndex (waypointList._oIndex (index))).
                        neighbours._oHash ()))
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        addNeighbours (((_eSeq) waypointList._oIndex (index)), (char) 0,
                            waypointList, (_eSeq) null, (char) 0, 0);
                    }
                    else
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        if ((1 == ((Waypoint) waypoints._oIndex (waypointList._oIndex (index))).
                            neighbours._oHash ()))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
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
                            if (_eSystem._lString ("target")._lEqual (((_eSeq) ((Waypoint) waypoints
                                ._oIndex (waypointList._oIndex (index))).neighbours._oIndex (0))))
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                addNeighbours (((_eSeq) waypointList._oIndex (index)), (char) 0,
                                    waypointList, (_eSeq) null, (char) 0, 0);
                            }
                            else
                            {
                            }
                        }
                        else
                        {
                        }
                    }
                }
                else
                {
                }
            }
        }
        else
        {
        }
        if ((((1 + index) < waypointList._oHash ()) && (!(0 == waypoints.dom ()._oHash ()))))
        {
            connectIsolatedWaypoints (waypointList, (_eSeq) null, (char) 0, (1 + index));
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1474,9");
    }

    public _eSeq getHeading (_eSeq airplaneId, char _t0airplaneId)
    {
        _lClassInvariantCheck ("ATC.pd:1510,5");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) airplaneId)))) throw new _xPre (
                    "ATC.pd:1512,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((1 < ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oHash ()))
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
            return ((Edge) ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oIndex (0)).
                ending.id;
        }
        else if ((1 == ((Airplane) airplanes._oIndex (((_eAny) airplaneId))).route._oHash ()))
        {
            return _eSystem._lString ("target");
        }
        else
        {
            return _eSystem._lString ("null");
        }
    }

    public void connectTerminalWaypoints (_eSeq edges, Edge _t0edges, int index, _eSeq
        terminalWaypoint, char _t0terminalWaypoint)
    {
        _lClassInvariantCheck ("ATC.pd:1528,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1530,19");
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
                if (!((index < edges._oHash ()))) throw new _xPre ("ATC.pd:1531,19");
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
                if (!(waypoints.dom ()._ovIn (((_eAny) terminalWaypoint)))) throw new _xPre (
                    "ATC.pd:1532,30");
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
                if (!((!(0 == edges._oHash ())))) throw new _xPre ("ATC.pd:1533,20");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem._lString ("source")._lEqual (terminalWaypoint))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (waypoints.dom ()._ovIn (((_eAny) ((Edge) edges._oIndex (index)).ending.id)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                _eMap _vUnshare_1542_25 = ((_eMap) waypoints._lClone ());
                waypoints = _vUnshare_1542_25;
                ((Waypoint) waypoints._osIndex (((_eAny) terminalWaypoint))).addNeighbour (((Edge)
                    edges._oIndex (index)).ending.id, (char) 0);
            }
            else
            {
            }
        }
        else if (_eSystem._lString ("target")._lEqual (terminalWaypoint))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (waypoints.dom ()._ovIn (((_eAny) ((Edge) edges._oIndex (index)).starting.id)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                _eMap _vUnshare_1551_25 = ((_eMap) waypoints._lClone ());
                waypoints = _vUnshare_1551_25;
                ((Waypoint) waypoints._osIndex (((_eAny) ((Edge) edges._oIndex (index)).starting.id))
                    ).addNeighbour (terminalWaypoint, (char) 0);
            }
            else
            {
            }
        }
        else
        {
        }
        if (((1 + index) < edges._oHash ()))
        {
            if (_eSystem._lString ("target")._lEqual (terminalWaypoint))
            {
                if (((1 + index) < 3))
                {
                    connectTerminalWaypoints (edges, (Edge) null, (1 + index), terminalWaypoint, (
                        char) 0);
                }
                else
                {
                }
            }
            else if (_eSystem._lString ("source")._lEqual (terminalWaypoint))
            {
                if (((1 + index) < 2))
                {
                    connectTerminalWaypoints (edges, (Edge) null, (1 + index), terminalWaypoint, (
                        char) 0);
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1536,9");
    }

    public void findShortestPath (_eSeq airplaneId, char _t0airplaneId)
    {
        _lClassInvariantCheck ("ATC.pd:1586,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(airplanes.dom ()._ovIn (((_eAny) airplaneId)))) throw new _xPre (
                    "ATC.pd:1588,24");
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
                if (!(((!waypoints.dom ()._ovIn (((_eAny) _eSystem._lString ("target")))) || ((
                    Waypoint) waypoints._oIndex (((_eAny) _eSystem._lString ("target"))))._lEqual (
                    new Waypoint (_eSystem._lString ("target"), (char) 0, ((Airplane) airplanes.
                    _oIndex (((_eAny) airplaneId))).endingX, ((Airplane) airplanes._oIndex (((_eAny)
                    airplaneId))).endingY))))) throw new _xPre ("ATC.pd:1589,13");
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
                if (!(((!waypoints.dom ()._ovIn (((_eAny) _eSystem._lString ("source")))) || ((
                    Waypoint) waypoints._oIndex (((_eAny) _eSystem._lString ("source"))))._lEqual (
                    new Waypoint (_eSystem._lString ("source"), (char) 0, ((Airplane) airplanes.
                    _oIndex (((_eAny) airplaneId))).x, ((Airplane) airplanes._oIndex (((_eAny)
                    airplaneId))).y))))) throw new _xPre ("ATC.pd:1591,13");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        waypoints = waypoints._nr_append (((_eAny) _eSystem._lString ("source")), (_eRtArrow) null,
            ((_eAny) new Waypoint (_eSystem._lString ("source"), (char) 0, ((Airplane) airplanes.
            _oIndex (((_eAny) airplaneId))).x, ((Airplane) airplanes._oIndex (((_eAny) airplaneId)))
            .y)));
        waypoints = waypoints._nr_append (((_eAny) _eSystem._lString ("target")), (_eRtArrow) null,
            ((_eAny) new Waypoint (_eSystem._lString ("target"), (char) 0, ((Airplane) airplanes.
            _oIndex (((_eAny) airplaneId))).endingX, ((Airplane) airplanes._oIndex (((_eAny)
            airplaneId))).endingY)));
        if ((waypoints.dom ()._ovIn (((_eAny) _eSystem._lString ("target"))) && waypoints.dom ().
            _ovIn (((_eAny) _eSystem._lString ("source")))))
        {
            {
                _eSet _vForYield_1603_25 = new _eSet ();
                {
                    _eSet _vCaptureBound_waypointId_1604_61 = waypoints.dom ();
                    int _vCaptureCount_waypointId_1604_61 = _vCaptureBound_waypointId_1604_61._oHash
                        ();
                    int _vLoopCounter_1604_39 = 0;
                    for (;;)
                    {
                        if ((_vLoopCounter_1604_39 == _vCaptureCount_waypointId_1604_61)) break;
                        if (((!_eSystem._lString ("target")._lEqual (((_eSeq)
                            _vCaptureBound_waypointId_1604_61._oIndex (_vLoopCounter_1604_39)))) &&
                            (!_eSystem._lString ("source")._lEqual (((_eSeq)
                            _vCaptureBound_waypointId_1604_61._oIndex (_vLoopCounter_1604_39))))))
                        {
                            _vForYield_1603_25 = _vForYield_1603_25.append (((_eAny) new Edge (((
                                Waypoint) waypoints._oIndex (_vCaptureBound_waypointId_1604_61.
                                _oIndex (_vLoopCounter_1604_39))), ((Waypoint) waypoints._oIndex (((
                                _eAny) _eSystem._lString ("target")))))));
                        }
                        else
                        {
                        }
                        _vLoopCounter_1604_39 = _eSystem._oSucc (_vLoopCounter_1604_39);
                    }
                }
                _eSeq _vLet_possibleTerminalEdges_1602_25 = _vForYield_1603_25.permndec ();
                if ((!(0 == _vLet_possibleTerminalEdges_1602_25._oHash ())))
                {
                    connectTerminalWaypoints (_vLet_possibleTerminalEdges_1602_25, (Edge) null, 0,
                        _eSystem._lString ("target"), (char) 0);
                }
                else
                {
                }
                {
                    _eSet _vForYield_1621_29 = new _eSet ();
                    {
                        _eSet _vCaptureBound_waypointId_1622_65 = waypoints.dom ();
                        int _vCaptureCount_waypointId_1622_65 = _vCaptureBound_waypointId_1622_65.
                            _oHash ();
                        int _vLoopCounter_1622_43 = 0;
                        for (;;)
                        {
                            if ((_vLoopCounter_1622_43 == _vCaptureCount_waypointId_1622_65)) break;
                            if (((!((_eSeq) _vCaptureBound_waypointId_1622_65._oIndex (
                                _vLoopCounter_1622_43))._lEqual (getHeading (airplaneId, (char) 0)))
                                && (!_eSystem._lString ("source")._lEqual (((_eSeq)
                                _vCaptureBound_waypointId_1622_65._oIndex (_vLoopCounter_1622_43)))))
                                )
                            {
                                _vForYield_1621_29 = _vForYield_1621_29.append (((_eAny) new Edge ((
                                    (Waypoint) waypoints._oIndex (((_eAny) _eSystem._lString (
                                    "source")))), ((Waypoint) waypoints._oIndex (
                                    _vCaptureBound_waypointId_1622_65._oIndex (_vLoopCounter_1622_43)
                                    )))));
                            }
                            else
                            {
                            }
                            _vLoopCounter_1622_43 = _eSystem._oSucc (_vLoopCounter_1622_43);
                        }
                    }
                    _eSeq _vLet_possibleStartingEdges_1620_29 = _vForYield_1621_29.permndec ();
                    if ((!(0 == _vLet_possibleStartingEdges_1620_29._oHash ())))
                    {
                        connectTerminalWaypoints (_vLet_possibleStartingEdges_1620_29, (Edge) null,
                            0, _eSystem._lString ("source"), (char) 0);
                    }
                    else
                    {
                    }
                }
                _eSeq _vLet_waypointList_1641_29 = waypoints.dom ().permndec ();
                if ((!(0 == _vLet_waypointList_1641_29._oHash ())))
                {
                    connectIsolatedWaypoints (_vLet_waypointList_1641_29, (_eSeq) null, (char) 0, 0);
                    dijkstras ();
                }
                else
                {
                }
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1594,9");
    }

    public void resetPriorityQueue ()
    {
        _lClassInvariantCheck ("ATC.pd:1660,20");
        newPath = new _eMap ();
        distance = new _eMap ();
        waypoints = waypoints.remove (((_eAny) _eSystem._lString ("source")));
        waypoints = waypoints.remove (((_eAny) _eSystem._lString ("target")));
        {
            _eSet _vCaptureBound_waypointId_1668_46 = waypoints.dom ();
            int _vCaptureCount_waypointId_1668_46 = _vCaptureBound_waypointId_1668_46._oHash ();
            int _vLoopCounter_1668_24 = 0;
            for (;;)
            {
                if ((_vLoopCounter_1668_24 == _vCaptureCount_waypointId_1668_46)) break;
                {
                    _eSeq _vForYield_1671_21 = new _eSeq ();
                    {
                        _eSeq _vCaptureBound_neighbour_1672_68 = ((Waypoint) waypoints._oIndex (
                            _vCaptureBound_waypointId_1668_46._oIndex (_vLoopCounter_1668_24))).
                            neighbours;
                        int _vCaptureCount_neighbour_1672_68 = _vCaptureBound_neighbour_1672_68.
                            _oHash ();
                        int _vLoopCounter_1672_35 = 0;
                        for (;;)
                        {
                            if ((_vLoopCounter_1672_35 == _vCaptureCount_neighbour_1672_68)) break;
                            if (((!_eSystem._lString ("source")._lEqual (((_eSeq)
                                _vCaptureBound_neighbour_1672_68._oIndex (_vLoopCounter_1672_35))))
                                && (!_eSystem._lString ("target")._lEqual (((_eSeq)
                                _vCaptureBound_neighbour_1672_68._oIndex (_vLoopCounter_1672_35))))))
                            {
                                _vForYield_1671_21 = _vForYield_1671_21.append (
                                    _vCaptureBound_neighbour_1672_68._oIndex (_vLoopCounter_1672_35))
                                    ;
                            }
                            else
                            {
                            }
                            _vLoopCounter_1672_35 = _eSystem._oSucc (_vLoopCounter_1672_35);
                        }
                    }
                    _eSeq _vLet_originalNeighbourList_1670_25 = _vForYield_1671_21.permndec ();
                    _eMap _vUnshare_1678_21 = ((_eMap) waypoints._lClone ());
                    waypoints = _vUnshare_1678_21;
                    ((Waypoint) waypoints._osIndex (_vCaptureBound_waypointId_1668_46._oIndex (
                        _vLoopCounter_1668_24))).setNeighbours (_vLet_originalNeighbourList_1670_25,
                        (_eSeq) null, (char) 0);
                }
                _vLoopCounter_1668_24 = _eSystem._oSucc (_vLoopCounter_1668_24);
            }
        }
        priorityQueue = new PriorityQueue ();
        _lClassInvariantCheck ("ATC.pd:1662,9");
    }

    public void updatePotentialCollisionsList ()
    {
        _lClassInvariantCheck ("ATC.pd:1687,20");
        {
            _eSeq _vForYield_1691_13 = new _eSeq ();
            {
                int _vCaptureCount_collision_1692_38 = potentialCollisions._oHash ();
                int _vLoopCounter_1692_27 = 0;
                for (;;)
                {
                    if ((_vLoopCounter_1692_27 == _vCaptureCount_collision_1692_38)) break;
                    if ((time <= ((PotentialCollision) potentialCollisions._oIndex (
                        _vLoopCounter_1692_27)).time))
                    {
                        _vForYield_1691_13 = _vForYield_1691_13.append (potentialCollisions._oIndex
                            (_vLoopCounter_1692_27));
                    }
                    else
                    {
                    }
                    _vLoopCounter_1692_27 = _eSystem._oSucc (_vLoopCounter_1692_27);
                }
            }
            potentialCollisions = _vForYield_1691_13.permndec ();
        }
        _lClassInvariantCheck ("ATC.pd:1689,9");
    }

    public void trackPotentialCollisionsForAllAirplanes (_eSeq airplaneList, _eSeq _t0airplaneList,
        char _t1airplaneList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1701,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1703,19");
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
                if (!((!(0 == airplaneList._oHash ())))) throw new _xPre ("ATC.pd:1704,27");
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
                if (!((index < airplaneList._oHash ()))) throw new _xPre ("ATC.pd:1705,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((index < airplaneList._oHash ()))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (airplanes.dom ()._ovIn (airplaneList._oIndex (index)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                trackPotentialCollisions (((_eSeq) airplaneList._oIndex (index)), (char) 0);
            }
            else
            {
            }
            if ((((1 + index) < airplaneList._oHash ()) && (!(0 == airplaneList._oHash ()))))
            {
                trackPotentialCollisionsForAllAirplanes (airplaneList, (_eSeq) null, (char) 0, (1 +
                    index));
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1708,9");
    }

    public void updateLocationForAllAirplanes (_eSeq airplaneList, _eSeq _t0airplaneList, char
        _t1airplaneList, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1729,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1731,19");
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
                if (!((!(0 == airplaneList._oHash ())))) throw new _xPre ("ATC.pd:1732,27");
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
                if (!((index < airplaneList._oHash ()))) throw new _xPre ("ATC.pd:1733,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((index < airplanes.dom ()._oHash ()))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (airplanes.dom ()._ovIn (airplaneList._oIndex (index)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                updateLocation (((_eSeq) airplaneList._oIndex (index)), (char) 0);
            }
            else
            {
            }
        }
        else
        {
        }
        if ((((1 + index) < airplaneList._oHash ()) && ((1 + index) < airplanes.dom ()._oHash ())))
        {
            updateLocationForAllAirplanes (airplaneList, (_eSeq) null, (char) 0, (1 + index));
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1736,9");
    }

    public void incrementCrashes (_eSeq airplaneList, _eSeq _t0airplaneList, char _t1airplaneList,
        _eWrapper__eAny airplanesAlreadyChecked, _eSet _t0airplanesAlreadyChecked, _eSeq
        _t1airplanesAlreadyChecked, char _t2airplanesAlreadyChecked, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1757,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1759,19");
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
                if (!((index < airplaneList._oHash ()))) throw new _xPre ("ATC.pd:1760,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (airplanes.dom ()._ovIn (airplaneList._oIndex (index)))
        {
            {
                _eSet _vForYield_1768_21 = new _eSet ();
                {
                    _eSet _vCaptureBound_id_1769_49 = airplanes.dom ();
                    int _vCaptureCount_id_1769_49 = _vCaptureBound_id_1769_49._oHash ();
                    int _vLoopCounter_1769_35 = 0;
                    for (;;)
                    {
                        if ((_vLoopCounter_1769_35 == _vCaptureCount_id_1769_49)) break;
                        boolean _vCondResult_1771_60;
                        if ((!((_eSet) airplanesAlreadyChecked.value)._ovIn (
                            _vCaptureBound_id_1769_49._oIndex (_vLoopCounter_1769_35))))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            _vCondResult_1771_60 = (!((_eSeq) airplaneList._oIndex (index))._lEqual
                                (((_eSeq) _vCaptureBound_id_1769_49._oIndex (_vLoopCounter_1769_35)))
                                );
                        }
                        else
                        {
                            _vCondResult_1771_60 = false;
                        }
                        boolean _vCondResult_1770_25;
                        if (_vCondResult_1771_60)
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            boolean _vCondResult_1772_29;
                            if ((new Calculations ().getAbsoluteValue ((((Airplane) airplanes.
                                _oIndex (_vCaptureBound_id_1769_49._oIndex (_vLoopCounter_1769_35)))
                                .z - ((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).z)
                                ) <= 20.0))
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                _vCondResult_1772_29 = (new Calculations ().findDistance (new Vector
                                    (((Airplane) airplanes._oIndex (_vCaptureBound_id_1769_49.
                                    _oIndex (_vLoopCounter_1769_35))).x, ((Airplane) airplanes.
                                    _oIndex (_vCaptureBound_id_1769_49._oIndex (
                                    _vLoopCounter_1769_35))).y), new Vector (((Airplane) airplanes.
                                    _oIndex (airplaneList._oIndex (index))).x, ((Airplane) airplanes
                                    ._oIndex (airplaneList._oIndex (index))).y)) <= 80.0);
                            }
                            else
                            {
                                _vCondResult_1772_29 = false;
                            }
                            _vCondResult_1770_25 = _vCondResult_1772_29;
                        }
                        else
                        {
                            _vCondResult_1770_25 = false;
                        }
                        if (_vCondResult_1770_25)
                        {
                            _vForYield_1768_21 = _vForYield_1768_21.append (
                                _vCaptureBound_id_1769_49._oIndex (_vLoopCounter_1769_35));
                        }
                        else
                        {
                        }
                        _vLoopCounter_1769_35 = _eSystem._oSucc (_vLoopCounter_1769_35);
                    }
                }
                _eSet _vLet_crashes_1767_25 = _vForYield_1768_21;
                noOfCrashes = (noOfCrashes + _vLet_crashes_1767_25._oHash ());
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                airplanesAlreadyChecked.value = ((_eSet) airplanesAlreadyChecked.value).append (
                    airplaneList._oIndex (index));
            }
        }
        else
        {
        }
        if (((1 + index) < airplaneList._oHash ()))
        {
            {
                _eSet _vSave_airplanesAlreadyChecked_1789_53 = ((_eSet) airplanesAlreadyChecked.
                    value);
                _eWrapper__eAny _vSchemaCallTemp_1789_53 = airplanesAlreadyChecked;
                incrementCrashes (airplaneList, (_eSeq) null, (char) 0, _vSchemaCallTemp_1789_53, (
                    _eSet) null, (_eSeq) null, (char) 0, (1 + index));
                airplanesAlreadyChecked.value = ((_eSet) _vSchemaCallTemp_1789_53.value);
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1763,9");
    }

    public void removeAirplanes (_eSeq airplaneList, _eSeq _t0airplaneList, char _t1airplaneList,
        int index)
    {
        _lClassInvariantCheck ("ATC.pd:1797,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1799,19");
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
                if (!((!(0 == airplaneList._oHash ())))) throw new _xPre ("ATC.pd:1800,27");
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
                if (!((index < airplaneList._oHash ()))) throw new _xPre ("ATC.pd:1801,19");
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
                if (!((0.0 <= time))) throw new _xPre ("ATC.pd:1802,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((index < airplaneList._oHash ()))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            if (airplanes.dom ()._ovIn (airplaneList._oIndex (index)))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                sumTimeConflicted = (sumTimeConflicted + ((Airplane) airplanes._oIndex (airplaneList
                    ._oIndex (index))).timeConflicted);
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if ((0.0 < ((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).
                    timeCloseToOtherPlanes))
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    sumPercentageOfTimeConflicted1 = (_eSystem._oDiv (((Airplane) airplanes._oIndex
                        (airplaneList._oIndex (index))).timeConflicted, ((Airplane) airplanes.
                        _oIndex (airplaneList._oIndex (index))).timeCloseToOtherPlanes) +
                        sumPercentageOfTimeConflicted1);
                }
                else
                {
                }
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if ((0.0 < ((Airplane) airplanes._oIndex (airplaneList._oIndex (index))).timeFlown))
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    sumPercentageOfTimeConflicted2 = (_eSystem._oDiv (((Airplane) airplanes._oIndex
                        (airplaneList._oIndex (index))).timeConflicted, ((Airplane) airplanes.
                        _oIndex (airplaneList._oIndex (index))).timeFlown) +
                        sumPercentageOfTimeConflicted2);
                }
                else
                {
                }
                numAirplanesThatLeftRegion = (numAirplanesThatLeftRegion + 1);
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                airplanes = airplanes.remove (airplaneList._oIndex (index));
                {
                    _eSeq _vForYield_1836_29 = new _eSeq ();
                    {
                        int _vCaptureCount_collision_1837_54 = potentialCollisions._oHash ();
                        int _vLoopCounter_1837_43 = 0;
                        for (;;)
                        {
                            if ((_vLoopCounter_1837_43 == _vCaptureCount_collision_1837_54)) break;
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            if (((- 1) == ((PotentialCollision) potentialCollisions._oIndex (
                                _vLoopCounter_1837_43)).involves (((_eSeq) airplaneList._oIndex (
                                index)), (char) 0)))
                            {
                                _vForYield_1836_29 = _vForYield_1836_29.append (potentialCollisions.
                                    _oIndex (_vLoopCounter_1837_43));
                            }
                            else
                            {
                            }
                            _vLoopCounter_1837_43 = _eSystem._oSucc (_vLoopCounter_1837_43);
                        }
                    }
                    potentialCollisions = _vForYield_1836_29.permndec ();
                }
            }
            else
            {
            }
            if ((((!(0 == airplaneList._oHash ())) && (!(0 == airplanes.dom ()._oHash ()))) && ((1 +
                index) < airplaneList._oHash ())))
            {
                removeAirplanes (airplaneList, (_eSeq) null, (char) 0, (1 + index));
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1805,9");
    }

    public void checkIfAirplanesWillInevitablyCollide (int potentialCollisionListSize, int index)
    {
        _lClassInvariantCheck ("ATC.pd:1861,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= index))) throw new _xPre ("ATC.pd:1863,19");
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
                if (!((!(0 == potentialCollisionListSize)))) throw new _xPre ("ATC.pd:1864,40");
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
                if (!((!(0 == airplanes.dom ()._oHash ())))) throw new _xPre ("ATC.pd:1865,28");
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
                if (!((index < potentialCollisionListSize))) throw new _xPre ("ATC.pd:1866,19");
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
                if (!((0.0 <= time))) throw new _xPre ("ATC.pd:1867,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (((index < potentialCollisionListSize) && (index < potentialCollisions._oHash ())))
        {
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                boolean _vCondResult_1874_65;
                if ((((PotentialCollision) potentialCollisions._oIndex (index)).minDist <= 80.0))
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    _vCondResult_1874_65 = (0.0 <= ((PotentialCollision) potentialCollisions._oIndex
                        (index)).minDist);
                }
                else
                {
                    _vCondResult_1874_65 = false;
                }
                boolean _vCondResult_1875_67;
                if (_vCondResult_1874_65)
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    _vCondResult_1875_67 = (((PotentialCollision) potentialCollisions._oIndex (index)
                        ).time <= (time + 1));
                }
                else
                {
                    _vCondResult_1875_67 = false;
                }
                boolean _vCondResult_1875_115;
                if (_vCondResult_1875_67)
                {
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    _vCondResult_1875_115 = (2 == ((PotentialCollision) potentialCollisions._oIndex
                        (index)).airplanes._oHash ());
                }
                else
                {
                    _vCondResult_1875_115 = false;
                }
                if (_vCondResult_1875_115)
                {
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
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
                        boolean _vCondResult_1878_83;
                        if (airplanes.dom ()._ovIn (((PotentialCollision) potentialCollisions.
                            _oIndex (index)).airplanes._oIndex (0)))
                        {
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
                            {
                                _eSystem.currentCheckNesting ++;
                                try
                                {
                                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                                }
                                catch (_xCannotEvaluate _lException)
                                {
                                }
                                _eSystem.currentCheckNesting --;
                            }
                            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                _eSystem.maxCheckNesting)
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
                            _vCondResult_1878_83 = airplanes.dom ()._ovIn (((PotentialCollision)
                                potentialCollisions._oIndex (index)).airplanes._oIndex (1));
                        }
                        else
                        {
                            _vCondResult_1878_83 = false;
                        }
                        if (_vCondResult_1878_83)
                        {
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                double verticalSpeed1 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (0))).verticalSpeed;
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                int preventiveMeasureType1 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (0))).preventiveMeasure.type;
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                double altitude1 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (0))).z;
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                double verticalSpeed2 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (1))).verticalSpeed;
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                int preventiveMeasureType2 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (1))).preventiveMeasure.type;
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= index))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
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
                                double altitude2 = ((Airplane) airplanes._oIndex (((
                                    PotentialCollision) potentialCollisions._oIndex (index)).
                                    airplanes._oIndex (1))).z;
                                if (((((0.0 < verticalSpeed1) && (0.0 < verticalSpeed2)) && (0.0 <
                                    altitude1)) && (0.0 < altitude2)))
                                {
                                    if ((preventiveMeasureType1 == PreventiveMeasureType.elevate))
                                    {
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if ((0.0 <= ((PotentialCollision) potentialCollisions.
                                            _oIndex (index)).time))
                                        {
                                            if (_eSystem.enableConstraint && _eSystem.
                                                currentCheckNesting <= _eSystem.maxCheckNesting)
                                            {
                                                _eSystem.currentCheckNesting ++;
                                                try
                                                {
                                                    if (!((0 <= index))) throw new _xConstraint (
                                                        "builtin.pd:91,18");
                                                }
                                                catch (_xCannotEvaluate _lException)
                                                {
                                                }
                                                _eSystem.currentCheckNesting --;
                                            }
                                            altitude1 = ((((time + 1) - ((PotentialCollision)
                                                potentialCollisions._oIndex (index)).time) *
                                                verticalSpeed1) + altitude1);
                                        }
                                        else
                                        {
                                        }
                                    }
                                    else if ((preventiveMeasureType1 == PreventiveMeasureType.
                                        descend))
                                    {
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if ((0.0 <= ((PotentialCollision) potentialCollisions.
                                            _oIndex (index)).time))
                                        {
                                            if (_eSystem.enableConstraint && _eSystem.
                                                currentCheckNesting <= _eSystem.maxCheckNesting)
                                            {
                                                _eSystem.currentCheckNesting ++;
                                                try
                                                {
                                                    if (!((0 <= index))) throw new _xConstraint (
                                                        "builtin.pd:91,18");
                                                }
                                                catch (_xCannotEvaluate _lException)
                                                {
                                                }
                                                _eSystem.currentCheckNesting --;
                                            }
                                            altitude1 = (altitude1 - (((time + 1) - ((
                                                PotentialCollision) potentialCollisions._oIndex (
                                                index)).time) * verticalSpeed1));
                                        }
                                        else
                                        {
                                        }
                                    }
                                    else
                                    {
                                    }
                                    if ((preventiveMeasureType2 == PreventiveMeasureType.elevate))
                                    {
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if ((0.0 <= ((PotentialCollision) potentialCollisions.
                                            _oIndex (index)).time))
                                        {
                                            if (_eSystem.enableConstraint && _eSystem.
                                                currentCheckNesting <= _eSystem.maxCheckNesting)
                                            {
                                                _eSystem.currentCheckNesting ++;
                                                try
                                                {
                                                    if (!((0 <= index))) throw new _xConstraint (
                                                        "builtin.pd:91,18");
                                                }
                                                catch (_xCannotEvaluate _lException)
                                                {
                                                }
                                                _eSystem.currentCheckNesting --;
                                            }
                                            altitude2 = ((((time + 1) - ((PotentialCollision)
                                                potentialCollisions._oIndex (index)).time) *
                                                verticalSpeed2) + altitude2);
                                        }
                                        else
                                        {
                                        }
                                    }
                                    else if ((preventiveMeasureType2 == PreventiveMeasureType.
                                        descend))
                                    {
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if ((0.0 <= ((PotentialCollision) potentialCollisions.
                                            _oIndex (index)).time))
                                        {
                                            if (_eSystem.enableConstraint && _eSystem.
                                                currentCheckNesting <= _eSystem.maxCheckNesting)
                                            {
                                                _eSystem.currentCheckNesting ++;
                                                try
                                                {
                                                    if (!((0 <= index))) throw new _xConstraint (
                                                        "builtin.pd:91,18");
                                                }
                                                catch (_xCannotEvaluate _lException)
                                                {
                                                }
                                                _eSystem.currentCheckNesting --;
                                            }
                                            altitude2 = (altitude2 - (((time + 1) - ((
                                                PotentialCollision) potentialCollisions._oIndex (
                                                index)).time) * verticalSpeed2));
                                        }
                                        else
                                        {
                                        }
                                    }
                                    else
                                    {
                                    }
                                    if ((new Calculations ().getAbsoluteValue ((altitude1 -
                                        altitude2)) <= 20.0))
                                    {
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= 0))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        airplanesToRemove = airplanesToRemove.append (((
                                            PotentialCollision) potentialCollisions._oIndex (index))
                                            .airplanes._oIndex (0));
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= index))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        if (_eSystem.enableConstraint && _eSystem.
                                            currentCheckNesting <= _eSystem.maxCheckNesting)
                                        {
                                            _eSystem.currentCheckNesting ++;
                                            try
                                            {
                                                if (!((0 <= 1))) throw new _xConstraint (
                                                    "builtin.pd:91,18");
                                            }
                                            catch (_xCannotEvaluate _lException)
                                            {
                                            }
                                            _eSystem.currentCheckNesting --;
                                        }
                                        airplanesToRemove = airplanesToRemove.append (((
                                            PotentialCollision) potentialCollisions._oIndex (index))
                                            .airplanes._oIndex (1));
                                        noOfCrashes = (1 + noOfCrashes);
                                    }
                                    else
                                    {
                                    }
                                }
                                else
                                {
                                }
                            }
                        }
                        else
                        {
                        }
                    }
                }
                else
                {
                }
            }
            if ((((!(0 == airplanes.dom ()._oHash ())) && ((1 + index) < potentialCollisions._oHash
                ())) && ((1 + index) < potentialCollisionListSize)))
            {
                checkIfAirplanesWillInevitablyCollide (potentialCollisionListSize, (1 + index));
            }
            else
            {
            }
        }
        else
        {
        }
        _lClassInvariantCheck ("ATC.pd:1870,9");
    }

    public void step ()
    {
        _lClassInvariantCheck ("ATC.pd:1959,20");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= time))) throw new _xPre ("ATC.pd:1961,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!(0 == airplanes.dom ()._oHash ())))
        {
            {
                _eSeq airplaneList = airplanes.dom ().permndec ();
                if ((1 < airplaneList._oHash ()))
                {
                    updatePotentialCollisionsList ();
                    trackPotentialCollisionsForAllAirplanes (airplaneList, (_eSeq) null, (char) 0, 0)
                        ;
                    if ((0 < potentialCollisions._oHash ()))
                    {
                        recurseOverPotentialCollisions (0, potentialCollisions._oHash ());
                        if (((!(0 == airplanes.dom ()._oHash ())) && (!(0 == potentialCollisions.
                            _oHash ()))))
                        {
                            checkIfAirplanesWillInevitablyCollide (potentialCollisions._oHash (), 0);
                        }
                        else
                        {
                        }
                    }
                    else
                    {
                    }
                }
                else
                {
                }
                airplaneList = airplanes.dom ().permndec ();
                if ((!(0 == airplaneList._oHash ())))
                {
                    updateLocationForAllAirplanes (airplaneList, (_eSeq) null, (char) 0, 0);
                }
                else
                {
                }
                airplaneList = airplanes.dom ().permndec ();
                if ((!(0 == airplaneList._oHash ())))
                {
                    {
                        _eSet airplaneSet = new _eSet ();
                        _eSet _vSave_airplaneSet_2007_69 = airplaneSet;
                        _eWrapper__eAny _vSchemaCallTemp_2007_69 = (new _eWrapper__eAny (airplaneSet)
                            );
                        incrementCrashes (airplaneList, (_eSeq) null, (char) 0,
                            _vSchemaCallTemp_2007_69, (_eSet) null, (_eSeq) null, (char) 0, 0);
                        airplaneSet = ((_eSet) _vSchemaCallTemp_2007_69.value);
                    }
                }
                else
                {
                }
                {
                    _eSet _vForYield_2015_33 = new _eSet ();
                    {
                        _eSet _vCaptureBound_id_2015_57 = airplanes.dom ();
                        int _vCaptureCount_id_2015_57 = _vCaptureBound_id_2015_57._oHash ();
                        int _vLoopCounter_2015_43 = 0;
                        for (;;)
                        {
                            if ((_vLoopCounter_2015_43 == _vCaptureCount_id_2015_57)) break;
                            if ((true == willCollide (((_eSeq) _vCaptureBound_id_2015_57._oIndex (
                                _vLoopCounter_2015_43)), (char) 0)))
                            {
                                _vForYield_2015_33 = _vForYield_2015_33.append (
                                    _vCaptureBound_id_2015_57._oIndex (_vLoopCounter_2015_43));
                            }
                            else
                            {
                            }
                            _vLoopCounter_2015_43 = _eSystem._oSucc (_vLoopCounter_2015_43);
                        }
                    }
                    _eSet _vLet_collidedAirplanes_2014_33 = _vForYield_2015_33;
                    airplanesToRemove = airplanesToRemove._oPlusPlus (
                        _vLet_collidedAirplanes_2014_33.permndec (), (_eTemplate_0) null);
                    if (((!(0 == airplanesToRemove._oHash ())) && (0.0 <= time)))
                    {
                        _eSeq _vAntiAlias_self__airplanesToRemove_2024_37 = airplanesToRemove;
                        removeAirplanes (_vAntiAlias_self__airplanesToRemove_2024_37, (_eSeq) null,
                            (char) 0, 0);
                    }
                    else
                    {
                    }
                }
                airplanesToRemove = new _eSeq ();
            }
        }
        else
        {
        }
        if ((0.0 <= (time + 1)))
        {
            time = (time + 1);
        }
        else
        {
            time = 0.0;
        }
        _lClassInvariantCheck ("ATC.pd:1963,9");
    }

    public ATC (double length, double width)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((20000.0 <= length) && (length <= 100000.0)))) throw new _xPre (
                    "ATC.pd:2047,20");
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
                if (!(((20000.0 <= width) && (width <= 100000.0)))) throw new _xPre (
                    "ATC.pd:2048,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        airplanes = new _eMap ();
        airplanesToRemove = new _eSeq ();
        waypoints = new _eMap ();
        potentialCollisions = new _eSeq ();
        time = 0.0;
        regionSize = new _ePair (((_eAny) new _eWrapper_real (width)), ((_eAny) new _eWrapper_real (
            length)));
        priorityQueue = new PriorityQueue ();
        distance = new _eMap ();
        noOfCrashes = 0;
        sumPercentageOfTimeConflicted1 = 0.0;
        sumPercentageOfTimeConflicted2 = 0.0;
        sumTimeConflicted = 0.0;
        numAirplanesThatLeftRegion = 0.0;
        newPath = new _eMap ();
        _lc_ATC ("ATC.pd:2063,13");
    }

    public boolean _lEqual (ATC _vArg_25_9)
    {
        if (this == _vArg_25_9)
        {
            return true;
        }
        _lClassInvariantCheck ("ATC.pd:25,9");
        return (((((((((((((_vArg_25_9.airplanes._lEqual (airplanes) && _vArg_25_9.airplanesToRemove
            ._lEqual (airplanesToRemove)) && _vArg_25_9.waypoints._lEqual (waypoints)) && _vArg_25_9
            .potentialCollisions._lEqual (potentialCollisions)) && _vArg_25_9.regionSize._lEqual (
            regionSize)) && (_vArg_25_9.time == time)) && _vArg_25_9.newPath._lEqual (newPath)) &&
            _vArg_25_9.distance._lEqual (distance)) && _vArg_25_9.priorityQueue._lEqual (
            priorityQueue)) && (_vArg_25_9.noOfCrashes == noOfCrashes)) && (_vArg_25_9.
            numAirplanesThatLeftRegion == numAirplanesThatLeftRegion)) && (_vArg_25_9.
            sumPercentageOfTimeConflicted1 == sumPercentageOfTimeConflicted1)) && (_vArg_25_9.
            sumPercentageOfTimeConflicted2 == sumPercentageOfTimeConflicted2)) && (_vArg_25_9.
            sumTimeConflicted == sumTimeConflicted));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == ATC.class && _lEqual ((ATC)
            _lArg));
    }

}


// End of file.
