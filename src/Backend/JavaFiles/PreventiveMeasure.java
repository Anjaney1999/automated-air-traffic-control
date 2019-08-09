//***********************************************************************************************
//* File: 'PreventiveMeasure.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/PreventiveMeasure.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class PreventiveMeasure extends _eAny
{
    public double floor;
    public double ceiling;
    public double target;
    public int type;
    public double ending;
    public PreventiveMeasure (double _vfloor, double _vceiling, double _vtarget, int _vtype,
        PreventiveMeasureType _t0_vtype, double _vending)
    {
        super ();
        floor = _vfloor;
        ceiling = _vceiling;
        target = _vtarget;
        type = _vtype;
        ending = _vending;
    }

    public boolean _lEqual (PreventiveMeasure _vArg_9_7)
    {
        if (this == _vArg_9_7)
        {
            return true;
        }
        return (((((_vArg_9_7.floor == floor) && (_vArg_9_7.ceiling == ceiling)) && (_vArg_9_7.
            target == target)) && (_vArg_9_7.type == type)) && (_vArg_9_7.ending == ending));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == PreventiveMeasure.class &&
            _lEqual ((PreventiveMeasure) _lArg));
    }

}


// End of file.
