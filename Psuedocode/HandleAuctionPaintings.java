public abstract class HandleAuctionPaintings
{
  //Desc: method creates an AuctionPainting in the database
  //Post: an AuctionPainting is created in the database
  public static void createAuctionPainting(AuctionPainting auction)
  {
    String statement = "SQL CREATE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method searches the database and retrieves any matching records. Search terms are passed in as a String
  //Return: returns an AuctionPainting array, with elements matching search terms
  public static AuctionPainting[] retrieveAuctionPaintings(AuctionPainting auction) //if string is empty, will bring all
  {
    String statement = "SELECT painterID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale FROM painters INNER"
     + " JOIN auction_paintings ON painters.painterID= auction_paintings.painterID"
    statement += stringify(auction)
    statement += " ORDER BY lastName, firstName" //probably needs to be changed
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connector.executeSQLQuery()
    ArrayList<AuctionPainting> auctionPaintings = new ArrayList<AuctionPainting>()
    for(int i = 0; i < result.size(); i++)
    {
      String firstName = result.get(i++)
      String lastName = result.get(i++)
      String titleOfWork = result.get(i++)
      int dateOfWork = Integer.parseInt(result.get(i++))
      double heightCM = Double.parseDouble(result.get(i++))
      double widthCM = Double.parseDouble(result.get(i++))
      String medium = result.get(i++)
      String subject = result.get(i++)
      double auctionSalePrice = Double.parseDouble(result.get(i++))
      Date auctionDateOfSale = Date.parse(result.get(i))
      auctionPaintings.add(firstName, lastName, titleOfWork, dateOfWork, classification, heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale)
    }
    return auctionPaintings.toArray()
  }  
  //Desc: method converts an AuctionPainting into a String
  //Return: returns a String for the SQL statement
  private static String stringify(AuctionPainting auction)
  {
    String result = ""
    int i = 0
    boolean[] flags = new boolean[9]
    int painterID = HandleArtist.getArtistID(new Artist(auction.getFirstName(), auction.getLastName(), -1))
    String titleOfWork = auction.getTitleOfWork()
    int dateOfWork = auction.getDateOfWork()
    double heightCM = auction.getHeightCM()
    double widthCM = auction.getWidthCM()
    String medium = auction.getMedium()
    String subject = auction.getSubject()
    double auctionSalePrice = auction.getAuctionSalePrice()
    Date auctionDateOfSale = auction.getAuctionDateOfSale()                                       
    if(painterID == -1) flags[i++] = true
    else result += "WHERE painterID ='" + painterID + "'"
    if(titleOfWork == null || titleOfWork.equals("")) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE titleOfWork ='" + titleOfWork + "'"
      else result += "AND titleOfWork ='" + titleOfWork + "'"
    }
    if(dateOfWork == -1) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE dateOfWork ='" + dateOfWork + "'"
      else result += "AND dateOfWork ='" + dateOfWork + "'"
    }
    if(classification == null || classification.equals("")) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE classification ='" + classification + "'"
      else result += "AND classification ='" + classification + "'"
    }
    if(widthCM < 0) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE widthCM ='" + widthCM + "'"
      else result += "AND widthCM ='" + widthCM + "'"
    }
    if(medium == null || medium.equals("")) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE medium ='" + medium + "'"
      else result += "AND medium ='" + medium + "'"
    }
    if(subject == null || subject.equals("")) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE subject ='" + subject + "'"
      else result += "AND subject ='" + subject + "'"
    }
    if(auctionSalePrice < 0) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE auctionSalePrice ='" + auctionSalePrice + "'"
      else result += "AND auctionSalePrice ='" + auctionSalePrice + "'"
    }
    if(auctionDateOfSale == null) flags[i] = true
    else
    {
      if(checkArray(flags, i++)) result += "WHERE auctionDateOfSale ='" + auctionDateOfSale.toString() + "'"
      else result += "AND auctionDateOfSale ='" + auctionDateOfSale.toString() + "'"
    }
    return result
  }
  //Desc: method to interate through flags and return boolean value
  //Return: returns true if all are true, false if any are false
  private static boolean checkArray(boolean[] flags, int count) throws ArrayIndexOutOfBoundsException
  {
    if(count > flags.length - 1 || count < 0) throw ArrayIndexOutOfBoundsException
    for(int i = 0; i <= count; i++)
    {
      if(!flags[i]) return false
    }
    return true
  }
  //Desc: method updates an AuctionPainting in the database
  //Post: an AuctionPainting is updated in the database
  public static void updateAuctionPainting(AuctionPainting auction)
  {
    String statement = "SQL UPDATE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method deletes an AuctionPainting in the database
  //Post: an AuctionPainting is deleted in the database
  public static void deleteAuctionPainting(AuctionPainting auction)
  {
    String statement = "SQL DELETE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
}