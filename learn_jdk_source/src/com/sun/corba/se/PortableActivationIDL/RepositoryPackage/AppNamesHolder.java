package com.sun.corba.se.PortableActivationIDL.RepositoryPackage;


/**
* com/sun/corba/se/PortableActivationIDL/RepositoryPackage/AppNamesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u25/1677/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Tuesday, October 7, 2014 2:27:05 PM PDT
*/


/** Type used for a list of application names
	*/
public final class AppNamesHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public AppNamesHolder ()
  {
  }

  public AppNamesHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = AppNamesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    AppNamesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return AppNamesHelper.type ();
  }

}
