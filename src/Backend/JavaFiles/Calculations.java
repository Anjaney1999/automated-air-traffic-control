//***********************************************************************************************
//* File: 'Calculations.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Calculations.pd'
//* by Perfect Developer version 4.10.02 at 13:35:56 UTC on Friday March 22nd 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Calculations extends _eAny
{
    public Vector findDirectionVector (Vector source, Vector destination)
    {
        Vector _vLet_vector_15_13 = new Vector ((destination.x - source.x), (destination.y - source.
            y));
        return findUnitVector (_vLet_vector_15_13);
    }

    public Vector findVector (Vector startPoint, Vector endPoint)
    {
        return new Vector ((endPoint.x - startPoint.x), (endPoint.y - startPoint.y));
    }

    public Vector findUnitVector (Vector vector)
    {
        if ((!((0.0 == vector.x) && (0.0 == vector.y))))
        {
            double _vLet_magnitude_30_21 = _eSystem._oExp ((_eSystem._oExp (vector.x, 2) + _eSystem.
                _oExp (vector.y, 2)), 0.5);
            return new Vector (_eSystem._oDiv (vector.x, _vLet_magnitude_30_21), _eSystem._oDiv (
                vector.y, _vLet_magnitude_30_21));
        }
        else
        {
            return vector;
        }
    }

    public double findDistance (Vector vector1, Vector vector2)
    {
        double _vLet_x_40_13 = (_eSystem._oExp ((vector2.x - vector1.x), 2) + _eSystem._oExp ((
            vector2.y - vector1.y), 2));
        return ((0.0 <= _vLet_x_40_13) ?
        getAbsoluteValue (_eSystem._oExp (_vLet_x_40_13, 0.5)) : 0.0);
    }

    public double getAbsoluteValue (double num)
    {
        return ((0.0 <= num) ?
        num : ((- 1.0) * num));
    }

    public _ePair computeTime (Vector positionVector1, Vector directionVector1, Vector
        positionVector2, Vector directionVector2, double radius, double timeToWaypoint1, double
        timeToWaypoint2)
    {
        double _vLet_x1_65_13 = positionVector1.x;
        double _vLet_u1_66_13 = directionVector1.x;
        double _vLet_y1_67_13 = positionVector1.y;
        double _vLet_v1_68_13 = directionVector1.y;
        double _vLet_x2_70_13 = positionVector2.x;
        double _vLet_u2_71_13 = directionVector2.x;
        double _vLet_y2_72_13 = positionVector2.y;
        double _vLet_v2_73_13 = directionVector2.y;
        double _vLet_a_76_13 = (((((_eSystem._oExp (_vLet_u1_66_13, 2.0) - ((2.0 * _vLet_u1_66_13) *
            _vLet_u2_71_13)) + _eSystem._oExp (_vLet_u2_71_13, 2.0)) + _eSystem._oExp (
            _vLet_v1_68_13, 2.0)) - ((2.0 * _vLet_v1_68_13) * _vLet_v2_73_13)) + _eSystem._oExp (
            _vLet_v2_73_13, 2.0));
        double _vLet_b_77_13 = (((((((((2.0 * _vLet_x1_65_13) * _vLet_u1_66_13) - ((2.0 *
            _vLet_x1_65_13) * _vLet_u2_71_13)) - ((2.0 * _vLet_u1_66_13) * _vLet_x2_70_13)) + ((2.0
            * _vLet_x2_70_13) * _vLet_u2_71_13)) + ((2.0 * _vLet_y1_67_13) * _vLet_v1_68_13)) - ((
            2.0 * _vLet_y1_67_13) * _vLet_v2_73_13)) - ((2.0 * _vLet_y2_72_13) * _vLet_v1_68_13)) +
            ((2.0 * _vLet_y2_72_13) * _vLet_v2_73_13));
        double _vLet_c_79_13 = ((((((_eSystem._oExp (_vLet_x1_65_13, 2.0) - ((2.0 * _vLet_x1_65_13)
            * _vLet_x2_70_13)) + _eSystem._oExp (_vLet_x2_70_13, 2.0)) + _eSystem._oExp (
            _vLet_y1_67_13, 2.0)) - ((2.0 * _vLet_y1_67_13) * _vLet_y2_72_13)) + _eSystem._oExp (
            _vLet_y2_72_13, 2.0)) - (4 * _eSystem._oExp (radius, 2)));
        double _vLet_currentDist_80_13 = findDistance (new Vector (_vLet_x1_65_13, _vLet_y1_67_13),
            new Vector (_vLet_x2_70_13, _vLet_y2_72_13));
        if (((2 * radius) <= _vLet_currentDist_80_13))
        {
            if ((!(0.0 == _vLet_a_76_13)))
            {
                double _vLet_d_87_25 = _eSystem._oDiv (_vLet_b_77_13, _vLet_a_76_13);
                double _vLet_timeClosest_88_25 = _eSystem._oDiv (((- 1) * _vLet_d_87_25), 2);
                if ((0.0 <= _vLet_timeClosest_88_25))
                {
                    double _vLet_minDist_93_33 = findDistance (new Vector (((_vLet_u1_66_13 *
                        _vLet_timeClosest_88_25) + _vLet_x1_65_13), ((_vLet_v1_68_13 *
                        _vLet_timeClosest_88_25) + _vLet_y1_67_13)), new Vector (((_vLet_u2_71_13 *
                        _vLet_timeClosest_88_25) + _vLet_x2_70_13), ((_vLet_v2_73_13 *
                        _vLet_timeClosest_88_25) + _vLet_y2_72_13)));
                    if ((_vLet_minDist_93_33 <= (2 * radius)))
                    {
                        if (((_vLet_timeClosest_88_25 <= timeToWaypoint1) && (
                            _vLet_timeClosest_88_25 <= timeToWaypoint2)))
                        {
                            return new _ePair (((_eAny) new _eWrapper_real (_vLet_timeClosest_88_25))
                                , ((_eAny) new _eWrapper_real (_vLet_minDist_93_33)));
                        }
                        else
                        {
                            if ((0.0 <= (_eSystem._oExp (_vLet_b_77_13, 2) - ((4 * _vLet_a_76_13) *
                                _vLet_c_79_13))))
                            {
                                double _vLet_solution1_106_49 = (_eSystem._oDiv (_eSystem._oExp ((
                                    _eSystem._oExp (_vLet_b_77_13, 2) - ((4 * _vLet_a_76_13) *
                                    _vLet_c_79_13)), 0.5), (2 * _vLet_a_76_13)) +
                                    _vLet_timeClosest_88_25);
                                double _vLet_solution2_107_49 = (_vLet_timeClosest_88_25 - _eSystem.
                                    _oDiv (_eSystem._oExp ((_eSystem._oExp (_vLet_b_77_13, 2) - ((4
                                    * _vLet_a_76_13) * _vLet_c_79_13)), 0.5), (2 * _vLet_a_76_13)));
                                return (((0.0 <= _vLet_solution1_106_49) && (0.0 <=
                                    _vLet_solution2_107_49)) ?
                                new _ePair (Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                                    _vLet_solution1_106_49)), ((_eAny) new _eWrapper_real (
                                    _vLet_solution2_107_49))), ((_eAny) new _eWrapper_real (
                                    _vLet_minDist_93_33))) : ((0.0 <= _vLet_solution1_106_49) && (
                                    _vLet_solution2_107_49 < 0.0)) ?
                                new _ePair (Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                                    _vLet_solution1_106_49)), ((_eAny) new _eWrapper_real (
                                    _vLet_timeClosest_88_25))), ((_eAny) new _eWrapper_real (
                                    _vLet_minDist_93_33))) : ((_vLet_solution1_106_49 < 0.0) && (0.0
                                    <= _vLet_solution2_107_49)) ?
                                new _ePair (Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                                    _vLet_solution2_107_49)), ((_eAny) new _eWrapper_real (
                                    _vLet_timeClosest_88_25))), ((_eAny) new _eWrapper_real (
                                    _vLet_minDist_93_33))) : new _ePair (((_eAny) new _eWrapper_real
                                    ((- 1.0))), ((_eAny) new _eWrapper_real (0.0))));
                            }
                            else
                            {
                                return new _ePair (((_eAny) new _eWrapper_real (
                                    _vLet_timeClosest_88_25)), ((_eAny) new _eWrapper_real (
                                    _vLet_minDist_93_33)));
                            }
                        }
                    }
                    else
                    {
                        return new _ePair (((_eAny) new _eWrapper_real ((- 2.0))), ((_eAny) new
                            _eWrapper_real (0.0)));
                    }
                }
                else
                {
                    if ((0.0 <= (_eSystem._oExp (_vLet_b_77_13, 2) - ((4 * _vLet_a_76_13) *
                        _vLet_c_79_13))))
                    {
                        double _vLet_solution1_137_37 = (_eSystem._oDiv (_eSystem._oExp ((_eSystem.
                            _oExp (_vLet_b_77_13, 2) - ((4 * _vLet_a_76_13) * _vLet_c_79_13)), 0.5),
                            (2 * _vLet_a_76_13)) + _vLet_timeClosest_88_25);
                        double _vLet_solution2_138_37 = (_vLet_timeClosest_88_25 - _eSystem._oDiv (
                            _eSystem._oExp ((_eSystem._oExp (_vLet_b_77_13, 2) - ((4 * _vLet_a_76_13)
                            * _vLet_c_79_13)), 0.5), (2 * _vLet_a_76_13)));
                        double _vLet_minDist1_139_37 = findDistance (new Vector (((_vLet_u1_66_13 *
                            _vLet_solution1_137_37) + _vLet_x1_65_13), ((_vLet_v1_68_13 *
                            _vLet_solution1_137_37) + _vLet_y1_67_13)), new Vector (((_vLet_u2_71_13
                            * _vLet_solution1_137_37) + _vLet_x2_70_13), ((_vLet_v2_73_13 *
                            _vLet_solution1_137_37) + _vLet_y2_72_13)));
                        double _vLet_minDist2_141_37 = findDistance (new Vector (((_vLet_u1_66_13 *
                            _vLet_solution2_138_37) + _vLet_x1_65_13), ((_vLet_v1_68_13 *
                            _vLet_solution2_138_37) + _vLet_y1_67_13)), new Vector (((_vLet_u2_71_13
                            * _vLet_solution2_138_37) + _vLet_x2_70_13), ((_vLet_v2_73_13 *
                            _vLet_solution2_138_37) + _vLet_y2_72_13)));
                        return ((((_eWrapper_real) Ertsys.RtsGlobals._rmin (((_eAny) new
                            _eWrapper_real (_vLet_minDist1_139_37)), ((_eAny) new _eWrapper_real (
                            _vLet_minDist2_141_37)))).value <= (2 * radius)) ?
                        (((0.0 <= _vLet_solution1_137_37) && (0.0 <= _vLet_solution2_138_37)) ?
                        new _ePair (Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                            _vLet_solution1_137_37)), ((_eAny) new _eWrapper_real (
                            _vLet_solution2_138_37))), Ertsys.RtsGlobals._rmin (((_eAny) new
                            _eWrapper_real (_vLet_minDist1_139_37)), ((_eAny) new _eWrapper_real (
                            _vLet_minDist2_141_37)))) : ((0.0 <= _vLet_solution1_137_37) && (
                            _vLet_solution2_138_37 < 0.0)) ?
                        new _ePair (((_eAny) new _eWrapper_real (_vLet_solution1_137_37)),
                            Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                            _vLet_minDist1_139_37)), ((_eAny) new _eWrapper_real (
                            _vLet_minDist2_141_37)))) : ((_vLet_solution1_137_37 < 0.0) && (0.0 <=
                            _vLet_solution2_138_37)) ?
                        new _ePair (((_eAny) new _eWrapper_real (_vLet_solution2_138_37)),
                            Ertsys.RtsGlobals._rmin (((_eAny) new _eWrapper_real (
                            _vLet_minDist1_139_37)), ((_eAny) new _eWrapper_real (
                            _vLet_minDist2_141_37)))) : new _ePair (((_eAny) new _eWrapper_real ((-
                            3.0))), ((_eAny) new _eWrapper_real (0.0)))) : new _ePair (((_eAny) new
                            _eWrapper_real ((- 4.0))), ((_eAny) new _eWrapper_real (0.0))));
                    }
                    else
                    {
                        return new _ePair (((_eAny) new _eWrapper_real ((- 5.0))), ((_eAny) new
                            _eWrapper_real (0.0)));
                    }
                }
            }
            else
            {
                return new _ePair (((_eAny) new _eWrapper_real ((- 6.0))), ((_eAny) new
                    _eWrapper_real (0.0)));
            }
        }
        else
        {
            return new _ePair (((_eAny) new _eWrapper_real (0.0)), ((_eAny) new _eWrapper_real (
                _vLet_currentDist_80_13)));
        }
    }

    public Calculations ()
    {
        super ();
    }

    public boolean _lEqual (Calculations _vArg_9_1)
    {
        if (this == _vArg_9_1)
        {
            return true;
        }
        return true;
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Calculations.class && _lEqual
            ((Calculations) _lArg));
    }

}


// End of file.
