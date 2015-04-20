// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.util.Hashtable;

public class ResourceIds
{

    private static Hashtable z_wHashtable;
    static String z_charString;
    static String z_longString;
    static String z_eString = "MIDlet-Install-Notify";
    static String z_tString = "_midlet";
    static String z_nString = "RIM-MIDlet-Icon-";
    static String p_middletKeysArray[] = {
        "MIDlet-Name", "MIDlet-Version", "MIDlet-Vendor"
    };
    static String z_elseaString[] = {
        "_midletName", "_version", "_vendor"
    };
    static String p_manifestVersionArray[] = {
        "Manifest-Version"
    };
    static String z_paString[] = {
        "_manifestVersion"
    };
    static String z_byteaString[];
    static String z_uaaString[][] = {
        {
            "MIDP-1.0", "MIDP-2.0"
        }, {
            "CLDC-1.0", "CLDC-1.1"
        }
    };
    static String z_faString[] = {
        "_midletProfile", "_midletConfiguration"
    };
    static String z_AaString[] = {
        "MIDlet-Jar-URL", "MIDlet-Jar-Size"
    };
    static String z_gaString[] = {
        "_url", "_midletJarSize"
    };
    static String z_tryaString[] = {
        "MIDlet-Description", "MIDlet-Icon", "MIDlet-Info-URL", "MIDlet-Data-Size"
    };
    static String z_yaString[] = {
        "_description", "_midletSuiteIcon28", "_midletInfo", "_midletDataSize"
    };
    static String z_sString = "RIM-Library-Flags";
    static String z_oString = "_appFlags";
    static String z_aString = "RIM-Platform";
    static String z_maString[] = {
        "MIDlet-", "RIM-MIDlet-Icon-Count-", "RIM-MIDlet-Flags-", "RIM-MIDlet-Position-", "RIM-MIDlet-NameResourceBundle-", "RIM-MIDlet-NameResourceId-"
    };
    static String z_newaString[] = {
        null, null, "_appFlags", "_appPosition", "_appNameResourceBundles", "_appNameResourceIds"
    };
    static String p_jadKeysArray[] = {
        "RIM-COD-URL", "RIM-COD-Size", "RIM-COD-Creation-Time", "RIM-COD-Module-Name", "RIM-COD-Module-Dependencies", "RIM-COD-SHA1"
    };
    static final int z_qI = 0;
    static final int z_ifI = 1;
    static final int z_zI = 2;
    static final int z_BI = 3;
    static final int z_forI = 4;
    static final int z_kI = 5;
    static int z_caseaI[] = {
        4, 0, 0, 0, 5, 2
    };
    static final int z_rI = 1;
    static final int z_gotoI = 1;
    static final int z_intI = 0;
    static final int z_dI = 1;
    static final int z_doI = 2;
    static final int z_iI = 3;
    static final int z_vI = 4;
    static final int z_xI = 5;
    static final String z_lString = "MIDlet-Permissions";
    static final String z_nullString = "MIDlet-Permissions-Opt";
    static final String z_jString = "MIDlet-Jar-RSA-SHA1";
    static final String z_cString = "MIDlet-Certificate-";
    static final String z_bString = "MIDP-2.0";

    public ResourceIds()
    {
    }

    public static String getId(String s)
    {
        return (String)z_wHashtable.get(s);
    }

    static
    {
        z_charString = "MicroEdition-Profile";
        z_longString = "MicroEdition-Configuration";
        z_byteaString = (new String[] {
            z_charString, z_longString
        });
        int j1 = p_middletKeysArray.length + p_manifestVersionArray.length + z_byteaString.length + z_AaString.length + z_tryaString.length + p_middletKeysArray.length;
        z_wHashtable = new Hashtable(j1 * 2);
        j1 = p_middletKeysArray.length;
        for(int i = 0; i < j1; i++)
            z_wHashtable.put(p_middletKeysArray[i], z_elseaString[i]);

        j1 = p_manifestVersionArray.length;
        for(int j = 0; j < j1; j++)
            z_wHashtable.put(p_manifestVersionArray[j], z_paString[j]);

        j1 = z_byteaString.length;
        for(int k = 0; k < j1; k++)
            z_wHashtable.put(z_byteaString[k], z_faString[k]);

        j1 = z_AaString.length;
        for(int l = 0; l < j1; l++)
            z_wHashtable.put(z_AaString[l], z_gaString[l]);

        j1 = z_tryaString.length;
        for(int i1 = 0; i1 < j1; i1++)
            z_wHashtable.put(z_tryaString[i1], z_yaString[i1]);

    }
}
