package org.omg.CosNaming.NamingContextPackage;

/**
* org/omg/CosNaming/NamingContextPackage/CannotProceedHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u25/1677/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, October 7, 2014 2:27:04 PM PDT
*/

public final class CannotProceedHolder implements org.omg.CORBA.portable.Streamable
{
  public CannotProceed value = null;

  public CannotProceedHolder ()
  {
  }

  public CannotProceedHolder (CannotProceed initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CannotProceedHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CannotProceedHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CannotProceedHelper.type ();
  }

}
