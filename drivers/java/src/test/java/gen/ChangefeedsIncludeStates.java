// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../templates/Test.java
package gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.*;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import static gen.TestingCommon.*;
import gen.TestingFramework;

public class ChangefeedsIncludeStates {
    Logger logger = LoggerFactory.getLogger(ChangefeedsIncludeStates.class);
    public static final RethinkDB r = RethinkDB.r;
    public static final Table tbl = r.db("test").table("tbl");

    Connection<?> conn;
    public String hostname = TestingFramework.getConfig().getHostName();
    public int port = TestingFramework.getConfig().getPort();

    @Before
    public void setUp() throws Exception {
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
        try {
            r.db("test").tableCreate("tbl").run(conn);
            r.db("test").table(tbl).wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down.");
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.db("test").tableDrop("tbl").run(conn);
        r.dbDrop("test").run(conn);
        r.db("rethinkdb").table("_debug_scratch").delete();
        conn.close(false);
    }

    // Autogenerated tests below

        @Test(timeout=120000)
    public void test() throws Exception {
                
        {
            // changefeeds/include_states.yaml #1
            /* [{'state': 'ready'}] */
            List expected_ = r.array(r.hashMap("state", "ready"));
            /* tbl.changes(squash=true, include_states=true).limit(1) */
            System.out.println("About to run #1: tbl.changes().optArg('squash', true).optArg('include_states', true).limit(1L)");
            Object obtained = runOrCatch(tbl.changes().optArg("squash", true).optArg("include_states", true).limit(1L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #1");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #1");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #1:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #2
            /* [{'state': 'initializing'}, {'new_val': None}, {'state': 'ready'}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("new_val", null), r.hashMap("state", "ready"));
            /* tbl.get(0).changes(squash=true, include_states=true).limit(3) */
            System.out.println("About to run #2: tbl.get(0L).changes().optArg('squash', true).optArg('include_states', true).limit(3L)");
            Object obtained = runOrCatch(tbl.get(0L).changes().optArg("squash", true).optArg("include_states", true).limit(3L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #2");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #2");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #2:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #3
            /* [{'state': 'initializing'}, {'state': 'ready'}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("state", "ready"));
            /* tbl.order_by(index='id').limit(10).changes(squash=true, include_states=true).limit(2) */
            System.out.println("About to run #3: tbl.orderBy().optArg('index', 'id').limit(10L).changes().optArg('squash', true).optArg('include_states', true).limit(2L)");
            Object obtained = runOrCatch(tbl.orderBy().optArg("index", "id").limit(10L).changes().optArg("squash", true).optArg("include_states", true).limit(2L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #3");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #3");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #3:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #4
            /* AnythingIsFine */
            Object expected_ = AnythingIsFine;
            /* tbl.insert({'id':1}) */
            System.out.println("About to run #4: tbl.insert(r.hashMap('id', 1L))");
            Object obtained = runOrCatch(tbl.insert(r.hashMap("id", 1L)),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #4");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #4");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #4:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #5
            /* [{'state': 'initializing'}, {'new_val': {'id': 1}}, {'state': 'ready'}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("new_val", r.hashMap("id", 1L)), r.hashMap("state", "ready"));
            /* tbl.order_by(index='id').limit(10).changes(squash=true, include_states=true).limit(3) */
            System.out.println("About to run #5: tbl.orderBy().optArg('index', 'id').limit(10L).changes().optArg('squash', true).optArg('include_states', true).limit(3L)");
            Object obtained = runOrCatch(tbl.orderBy().optArg("index", "id").limit(10L).changes().optArg("squash", true).optArg("include_states", true).limit(3L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #5");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #5");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #5:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        // changefeeds/include_states.yaml #6
        // tblchanges = tbl.changes(squash=true, include_states=true)
        System.out.println("Possibly executing: Changes tblchanges = (Changes) (tbl.changes().optArg('squash', true).optArg('include_states', true));");
        Object tblchanges = maybeRun((Changes) (tbl.changes().optArg("squash", true).optArg("include_states", true)), conn);
                
        {
            // changefeeds/include_states.yaml #7
            /* AnythingIsFine */
            Object expected_ = AnythingIsFine;
            /* tbl.insert({'id':2}) */
            System.out.println("About to run #7: tbl.insert(r.hashMap('id', 2L))");
            Object obtained = runOrCatch(tbl.insert(r.hashMap("id", 2L)),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #7");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #7");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #7:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #8
            /* [{'state': 'ready'}, {'new_val': {'id': 2}, 'old_val': None}] */
            List expected_ = r.array(r.hashMap("state", "ready"), r.hashMap("new_val", r.hashMap("id", 2L)).with("old_val", null));
            /* fetch(tblchanges, 2) */
            System.out.println("About to run #8: fetch(tblchanges, 2L)");
            Object obtained = runOrCatch(fetch(tblchanges, 2L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #8");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #8");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #8:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        // changefeeds/include_states.yaml #9
        // getchanges = tbl.get(2).changes(include_states=true)
        System.out.println("Possibly executing: Changes getchanges = (Changes) (tbl.get(2L).changes().optArg('include_states', true));");
        Object getchanges = maybeRun((Changes) (tbl.get(2L).changes().optArg("include_states", true)), conn);
                
        {
            // changefeeds/include_states.yaml #10
            /* AnythingIsFine */
            Object expected_ = AnythingIsFine;
            /* tbl.get(2).update({'a':1}) */
            System.out.println("About to run #10: tbl.get(2L).update(r.hashMap('a', 1L))");
            Object obtained = runOrCatch(tbl.get(2L).update(r.hashMap("a", 1L)),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #10");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #10");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #10:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #11
            /* [{'state': 'initializing'}, {'new_val': {'id': 2}}, {'state': 'ready'}, {'new_val': {'id': 2, 'a': 1}, 'old_val': {'id': 2}}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("new_val", r.hashMap("id", 2L)), r.hashMap("state", "ready"), r.hashMap("new_val", r.hashMap("id", 2L).with("a", 1L)).with("old_val", r.hashMap("id", 2L)));
            /* fetch(getchanges, 4) */
            System.out.println("About to run #11: fetch(getchanges, 4L)");
            Object obtained = runOrCatch(fetch(getchanges, 4L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #11");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #11");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #11:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        // changefeeds/include_states.yaml #12
        // limitchanges = tbl.order_by(index='id').limit(10).changes(include_states=true)
        System.out.println("Possibly executing: Changes limitchanges = (Changes) (tbl.orderBy().optArg('index', 'id').limit(10L).changes().optArg('include_states', true));");
        Object limitchanges = maybeRun((Changes) (tbl.orderBy().optArg("index", "id").limit(10L).changes().optArg("include_states", true)), conn);
                
        // changefeeds/include_states.yaml #13
        // limitchangesdesc = tbl.order_by(index=r.desc('id')).limit(10).changes(include_states=true)
        System.out.println("Possibly executing: Changes limitchangesdesc = (Changes) (tbl.orderBy().optArg('index', r.desc('id')).limit(10L).changes().optArg('include_states', true));");
        Object limitchangesdesc = maybeRun((Changes) (tbl.orderBy().optArg("index", r.desc("id")).limit(10L).changes().optArg("include_states", true)), conn);
                
        {
            // changefeeds/include_states.yaml #14
            /* AnythingIsFine */
            Object expected_ = AnythingIsFine;
            /* tbl.insert({'id':3}) */
            System.out.println("About to run #14: tbl.insert(r.hashMap('id', 3L))");
            Object obtained = runOrCatch(tbl.insert(r.hashMap("id", 3L)),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #14");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #14");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #14:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #15
            /* [{'state': 'initializing'}, {'new_val': {'id': 1}}, {'new_val': {'id': 2, 'a': 1}}, {'state': 'ready'}, {'new_val': {'id': 3}, 'old_val': None}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("new_val", r.hashMap("id", 1L)), r.hashMap("new_val", r.hashMap("id", 2L).with("a", 1L)), r.hashMap("state", "ready"), r.hashMap("new_val", r.hashMap("id", 3L)).with("old_val", null));
            /* fetch(limitchanges, 5) */
            System.out.println("About to run #15: fetch(limitchanges, 5L)");
            Object obtained = runOrCatch(fetch(limitchanges, 5L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #15");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #15");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #15:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // changefeeds/include_states.yaml #16
            /* [{'state': 'initializing'}, {'new_val': {'id': 2, 'a': 1}}, {'new_val': {'id': 1}}, {'state': 'ready'}, {'new_val': {'id': 3}, 'old_val': None}] */
            List expected_ = r.array(r.hashMap("state", "initializing"), r.hashMap("new_val", r.hashMap("id", 2L).with("a", 1L)), r.hashMap("new_val", r.hashMap("id", 1L)), r.hashMap("state", "ready"), r.hashMap("new_val", r.hashMap("id", 3L)).with("old_val", null));
            /* fetch(limitchangesdesc, 5) */
            System.out.println("About to run #16: fetch(limitchangesdesc, 5L)");
            Object obtained = runOrCatch(fetch(limitchangesdesc, 5L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #16");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #16");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}