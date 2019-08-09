//***********************************************************************************************
//* File: 'Airplane.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Airplane.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Airplane extends _eAny
{
    final void _lc_Airplane (String _lArg)
    {
        if (_eSystem.enableClassInvariantItem && _eSystem.currentCheckNesting <= _eSystem.
            maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 < verticalSpeed))) throw new _xClassInvariantItem ("Airplane.pd:55,27",
                    _lArg);
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
                if (!((170.0 <= speed))) throw new _xClassInvariantItem ("Airplane.pd:57,19", _lArg);
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
                if (!(((0.0 <= x) && (0.0 <= y)))) throw new _xClassInvariantItem (
                    "Airplane.pd:59,15", _lArg);
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
                if (!(((0.0 <= startingX) && (0.0 <= startingY)))) throw new _xClassInvariantItem (
                    "Airplane.pd:60,23", _lArg);
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
                if (!(((0.0 <= endingX) && (0.0 <= endingY)))) throw new _xClassInvariantItem (
                    "Airplane.pd:61,21", _lArg);
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
                if (!((0.0 <= z))) throw new _xClassInvariantItem ("Airplane.pd:62,17", _lArg);
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
    }

    protected void _lClassInvariantCheck (String _lArg)
    {
        _lc_Airplane (_lArg);
    }

    public _eSeq id;
    public double x;
    public double y;
    public double z;
    protected double startingX;
    protected double startingY;
    public double endingX;
    public double endingY;
    public _eSeq route;
    public _eSeq action;
    public int status;
    public Vector currentVelocity;
    public Vector nextVelocity;
    public double speed;
    public boolean examined;
    public double timeToWaypoint;
    public PreventiveMeasure preventiveMeasure;
    public double verticalSpeed;
    public double timeCloseToOtherPlanes;
    public double timeConflicted;
    public double timeFlown;
    public _eSeq getAirplaneAction ()
    {
        _lClassInvariantCheck ("Airplane.pd:87,5");
        return PreventiveMeasureType._ltoString (preventiveMeasure.type);
    }

    public double getAirplaneCeiling ()
    {
        _lClassInvariantCheck ("Airplane.pd:93,5");
        return preventiveMeasure.ceiling;
    }

    public double getAirplaneFloor ()
    {
        _lClassInvariantCheck ("Airplane.pd:99,5");
        return preventiveMeasure.floor;
    }

    public void setLocation (double newX, double newY)
    {
        _lClassInvariantCheck ("Airplane.pd:107,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= newX))) throw new _xPre ("Airplane.pd:110,18");
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
                if (!((0.0 <= newY))) throw new _xPre ("Airplane.pd:111,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        x = newX;
        y = newY;
        _lClassInvariantCheck ("Airplane.pd:113,9");
    }

    public void setTimeConflicted (double t)
    {
        _lClassInvariantCheck ("Airplane.pd:119,13");
        if ((0.0 <= t))
        {
            timeConflicted = t;
        }
        else
        {
            timeConflicted = 0.0;
        }
        _lClassInvariantCheck ("Airplane.pd:121,9");
    }

    public void setTimeFlown (double t)
    {
        _lClassInvariantCheck ("Airplane.pd:128,13");
        if ((0.0 <= t))
        {
            timeFlown = t;
        }
        else
        {
            timeFlown = 0.0;
        }
        _lClassInvariantCheck ("Airplane.pd:130,9");
    }

    public void setAction (_eSeq a, char _t0a)
    {
        _lClassInvariantCheck ("Airplane.pd:137,13");
        action = a;
        _lClassInvariantCheck ("Airplane.pd:139,9");
    }

    public void setTimeCloseToOtherPlanes (double t)
    {
        _lClassInvariantCheck ("Airplane.pd:143,13");
        if ((0.0 <= t))
        {
            timeCloseToOtherPlanes = t;
        }
        else
        {
            timeCloseToOtherPlanes = 0.0;
        }
        _lClassInvariantCheck ("Airplane.pd:145,9");
    }

    public void setCurrentVelocity (Vector velocity)
    {
        _lClassInvariantCheck ("Airplane.pd:154,11");
        currentVelocity = velocity;
        _lClassInvariantCheck ("Airplane.pd:156,7");
    }

    public void setAltitude (double altitude)
    {
        _lClassInvariantCheck ("Airplane.pd:159,13");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((5000.0 <= altitude) && (altitude <= 15000.0)))) throw new _xPre (
                    "Airplane.pd:162,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        z = altitude;
        _lClassInvariantCheck ("Airplane.pd:164,7");
    }

    public void setStatus (int newStatus, Status _t0newStatus)
    {
        _lClassInvariantCheck ("Airplane.pd:169,11");
        if ((!(status == newStatus)))
        {
            status = newStatus;
        }
        else
        {
        }
        _lClassInvariantCheck ("Airplane.pd:171,5");
    }

    public void setExamined (boolean isExamined)
    {
        _lClassInvariantCheck ("Airplane.pd:180,11");
        examined = isExamined;
        _lClassInvariantCheck ("Airplane.pd:182,7");
    }

    public void updateRoute ()
    {
        _lClassInvariantCheck ("Airplane.pd:186,11");
        if ((1 < route._oHash ()))
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
            route = route.remove (0);
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
            timeToWaypoint = _eSystem._oDiv (((Edge) route._oIndex (0)).distance, speed);
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
            currentVelocity = new Vector ((speed * ((Edge) route._oIndex (0)).direction.x), (speed *
                ((Edge) route._oIndex (0)).direction.y));
        }
        else
        {
        }
        _lClassInvariantCheck ("Airplane.pd:188,5");
    }

    public void resetRoute ()
    {
        _lClassInvariantCheck ("Airplane.pd:202,11");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == route._oHash ())))) throw new _xPre ("Airplane.pd:204,14");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        Edge _vLet_newPath_207_11 = new Edge (new Waypoint (x, y), ((Edge) route.last ()).ending);
        route = new _eSeq ();
        route = route.append (((_eAny) _vLet_newPath_207_11));
        _lClassInvariantCheck ("Airplane.pd:206,5");
    }

    public void updateTimeToWaypoint (double newTimeToWaypoint)
    {
        _lClassInvariantCheck ("Airplane.pd:214,11");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= newTimeToWaypoint))) throw new _xPre ("Airplane.pd:216,25");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((0.0 <= newTimeToWaypoint))
        {
            timeToWaypoint = newTimeToWaypoint;
        }
        else
        {
        }
        _lClassInvariantCheck ("Airplane.pd:218,5");
    }

    public void setPreventiveMeasure (double floor, double ceiling, double target, int type,
        PreventiveMeasureType _t0type, double endingTime)
    {
        _lClassInvariantCheck ("Airplane.pd:228,11");
        preventiveMeasure = new PreventiveMeasure (floor, ceiling, target, type, (
            PreventiveMeasureType) null, endingTime);
        _lClassInvariantCheck ("Airplane.pd:231,7");
    }

    public void configureFinalPath (_ePair paths, Edge _t0paths, Edge _t1paths)
    {
        _lClassInvariantCheck ("Airplane.pd:234,11");
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == route._oHash ())))) throw new _xPre ("Airplane.pd:236,14");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        int _vCaptureConstraintCheck_239_36 = (route._oHash () - 1);
        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0 <= _vCaptureConstraintCheck_239_36))) throw new _xConstraint (
                    "builtin.pd:91,18");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        route = route.remove (_vCaptureConstraintCheck_239_36);
        route = route.append (paths.x);
        route = route.append (paths.y);
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
        currentVelocity = new Vector ((speed * ((Edge) route._oIndex (0)).direction.x), (speed * ((
            Edge) route._oIndex (0)).direction.y));
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
        timeToWaypoint = _eSystem._oDiv (((Edge) route._oIndex (0)).distance, speed);
        _lClassInvariantCheck ("Airplane.pd:238,5");
    }

    public Airplane (_eSeq _vid, char _t0_vid, _eSeq _vroute, Edge _t0_vroute, double _vspeed,
        double _vz)
    {
        super ();
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((8000.0 <= _vz) && (_vz <= 12000.0)))) throw new _xPre ("Airplane.pd:251,9");
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
                boolean _vCondResult_253_19;
                if ((!(0 == _vroute._oHash ())))
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
                    _vCondResult_253_19 = (0.0 <= ((Edge) _vroute._oIndex (0)).distance);
                }
                else
                {
                    _vCondResult_253_19 = false;
                }
                boolean _vCondResult_253_46;
                if (_vCondResult_253_19)
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
                    _vCondResult_253_46 = (0.0 <= ((Edge) _vroute._oIndex (0)).starting.x);
                }
                else
                {
                    _vCondResult_253_46 = false;
                }
                boolean _vCondResult_254_34;
                if (_vCondResult_253_46)
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
                    _vCondResult_254_34 = (0.0 <= ((Edge) _vroute._oIndex (0)).starting.y);
                }
                else
                {
                    _vCondResult_254_34 = false;
                }
                if (!(_vCondResult_254_34)) throw new _xPre ("Airplane.pd:254,34");
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
                boolean _vCondResult_255_32;
                if ((0.0 <= ((Edge) _vroute._oIndex (0)).ending.x))
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
                    _vCondResult_255_32 = (0.0 <= ((Edge) _vroute._oIndex (0)).ending.y);
                }
                else
                {
                    _vCondResult_255_32 = false;
                }
                if (!(_vCondResult_255_32)) throw new _xPre ("Airplane.pd:255,32");
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
                if (!((170.0 <= _vspeed))) throw new _xPre ("Airplane.pd:256,13");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        id = _vid;
        route = _vroute;
        speed = _vspeed;
        z = _vz;
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
        x = ((Edge) _vroute._oIndex (0)).starting.x;
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
        y = ((Edge) _vroute._oIndex (0)).starting.y;
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
        currentVelocity = new Vector ((_vspeed * ((Edge) _vroute._oIndex (0)).direction.x), (_vspeed
            * ((Edge) _vroute._oIndex (0)).direction.y));
        nextVelocity = new Vector (0.0, 0.0);
        examined = false;
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
        startingX = ((Edge) _vroute._oIndex (0)).starting.x;
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
        startingY = ((Edge) _vroute._oIndex (0)).starting.y;
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
        endingX = ((Edge) _vroute._oIndex (0)).ending.x;
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
        endingY = ((Edge) _vroute._oIndex (0)).ending.y;
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
        timeToWaypoint = _eSystem._oDiv (((Edge) _vroute._oIndex (0)).distance, _vspeed);
        preventiveMeasure = new PreventiveMeasure (5000.0, 15000.0, 0.0, PreventiveMeasureType.
            noChange, (PreventiveMeasureType) null, 0.0);
        status = Status.green;
        verticalSpeed = (0.0524 * _vspeed);
        action = _eSystem._lString ("none");
        timeConflicted = 0.0;
        timeCloseToOtherPlanes = 0.0;
        timeFlown = 0.0;
        _lc_Airplane ("Airplane.pd:279,13");
    }

    public boolean _lEqual (Airplane _vArg_16_7)
    {
        if (this == _vArg_16_7)
        {
            return true;
        }
        _lClassInvariantCheck ("Airplane.pd:16,7");
        return ((((((((((((((((((((_vArg_16_7.id._lEqual (id) && (_vArg_16_7.x == x)) && (_vArg_16_7
            .y == y)) && (_vArg_16_7.z == z)) && (_vArg_16_7.startingX == startingX)) && (_vArg_16_7
            .startingY == startingY)) && (_vArg_16_7.endingX == endingX)) && (_vArg_16_7.endingY ==
            endingY)) && _vArg_16_7.route._lEqual (route)) && _vArg_16_7.action._lEqual (action)) &&
            (_vArg_16_7.status == status)) && _vArg_16_7.currentVelocity._lEqual (currentVelocity))
            && _vArg_16_7.nextVelocity._lEqual (nextVelocity)) && (_vArg_16_7.speed == speed)) && (
            _vArg_16_7.examined == examined)) && (_vArg_16_7.timeToWaypoint == timeToWaypoint)) &&
            _vArg_16_7.preventiveMeasure._lEqual (preventiveMeasure)) && (_vArg_16_7.verticalSpeed
            == verticalSpeed)) && (_vArg_16_7.timeCloseToOtherPlanes == timeCloseToOtherPlanes)) &&
            (_vArg_16_7.timeConflicted == timeConflicted)) && (_vArg_16_7.timeFlown == timeFlown));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Airplane.class && _lEqual ((
            Airplane) _lArg));
    }

}


// End of file.
