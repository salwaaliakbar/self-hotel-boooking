
/*-------------------------- NAME : SALWA ALI AKBAR and maryam jameela ----------------------------
---------------------------- CMS : 023-22-0187 ---------------------------------
---------------------------- SEMESTER : 3rd ------------------------------------
------------------------- PROJECT : SELF HOTEL BOOKING PROJECT -------------------------

ABOUT PROGRAM :
This program provide a facility to book hotel room by own(customer) , and can order food also. For take advantage
from this program customer have to registor itself via booking room. Then , they can sign in their account and can
order the food , leave the hotel(receive bill receipt) and can reset their password.
This program also has a menu bar , through this customer can see the prices of room and food before booking the
room and order the food. Also menu bar contain customer's record (leaving customer and existing customer). This is
valid only for Admin. Before showing the customer's record this program must autenticate the admin by LOGIN PAGE.
Admin must enter the username and password then pressed login button , if the entered username and password are correct , then
the customer's record(existing customer or leaving customer) display on screen.

						"ADMIN USERNAME = Salwa  , ADMIN PASSWORD = S@lwa12345"
*/

import Hotel.*;

//------------------------------ MAIN CLASS --------------------------------------------

class Home
{
	public static void main(String args[])
	{
		Menu m = new Menu();
		m.Disply();
	}
}