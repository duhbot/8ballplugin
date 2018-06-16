package org.duh102.duhbot.eightball;

import java.util.*;

import org.pircbotx.hooks.*;
import org.pircbotx.hooks.events.*;
import org.pircbotx.Colors;

import org.duh102.duhbot.functions.*;

public class EightBallPlugin extends ListenerAdapter implements DuhbotFunction
{
  static String responses[] = {
    "It is certain.",
    "It is decidedly so.",
    "Without a doubt.",
    "Yes - definitely.",
    "You may rely on it.",
    "As I see it, yes.",
    "Most likely.",
    "Outlook good.",
    "Yes.",
    "Signs point to yes.",
    "Reply hazy, try again",
    "Ask again later.",
    "Better not tell you now.",
    "Cannot predict now.",
    "Concentrate and ask again.",
    "Don't count on it.",
    "My reply is no.",
    "My sources say no",
    "Outlook not so good.",
    "Very doubtful."
  };
  Random rand = null;
  public EightBallPlugin()
  {
    rand = new Random();
  }
 
  public void onMessage(MessageEvent event)
  {
    String message = Colors.removeFormattingAndColors(event.getMessage());
    if(message.startsWith(".8ball"))
    {
      event.respond(responses[rand.nextInt(responses.length)]);
    }
  }
  
  public HashMap<String,String> getHelpFunctions()
  {
    HashMap<String,String> helpFunctions = new HashMap<String,String>();
    helpFunctions.put(".8ball", "Responds with a yes/no/maybe answer, of varying certainty");
    return helpFunctions;
  }
  
  public String getPluginName()
  {
    return "8-ball";
  }
  
  public ListenerAdapter getAdapter()
  {
    return this;
  }
}
