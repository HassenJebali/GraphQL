package graphpql;


import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graph")
public class GraphQLEndPoint extends SimpleGraphQLServlet {

    public GraphQLEndPoint() {
        super(buildSchema());
    }


    private static GraphQLSchema buildSchema() {
        ModuleBusiness MBus = new ModuleBusiness();
        UniteEnseignementBusiness UEbus = new UniteEnseignementBusiness();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new QueryGraph(MBus, UEbus),
                        new MutationGraph(MBus, UEbus)
                ).build().makeExecutableSchema();
    }


}
