//***********************************************************************************************
//* File: 'Vector.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Vector.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Vector extends _eAny
{
    public double x;
    public double y;
    public Vector (double _vx, double _vy)
    {
        super ();
        x = _vx;
        y = _vy;
    }

    public boolean _lEqual (Vector _vArg_7_7)
    {
        if (this == _vArg_7_7)
        {
            return true;
        }
        return ((_vArg_7_7.x == x) && (_vArg_7_7.y == y));
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Vector.class && _lEqual ((
            Vector) _lArg));
    }

}


// End of file.
