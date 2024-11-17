package org.example.Ex10Sinks;

import org.example.Ex10Sinks.assignment.SlackMember;
import org.example.Ex10Sinks.assignment.SlackRoom;
import org.example.common.Util;

public class Ex08SlackAssignment {

    public static void main(String[] args) {

        var room = new SlackRoom("reactor");
        var sam = new SlackMember("sam");
        var jake = new SlackMember("jake");
        var mike = new SlackMember("mike");

        // add 2 members
        room.addMember(sam);
        room.addMember(jake);

        sam.says("Hi all..");
        Util.sleepSeconds(4);

        jake.says("Hey!");
        sam.says("I simply wanted to say hi..");
        Util.sleepSeconds(4);

        room.addMember(mike);
        mike.says("Hey guys..glad to be here...");


    }

}
