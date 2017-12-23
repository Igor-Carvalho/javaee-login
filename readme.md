# Instalação

## Payara
- Baixe e instale o [payara fish](https://www.payara.fish/downloads) em um diretório qualquer (`~/payara41`)
- Copie  o [driver jdbc postgres](https://jdbc.postgresql.org/download/postgresql-42.1.4.jar) para a pasta `~/payara41/glassfish/lib`
- Adicione o payara como um servidor glassfish no netbeans.
- Inicie o servidor e acesse [http://localhost:4848](http://localhost:4848)
- Na aba `JDBC Connection Pools` crie um novo pool de conexão (qualquer nome) do tipo `javax.sql.DataSource` com classname `org.postgresql.ds.PGSimpleDataSource`. Preencha as configurações de conexão com os dados do seu banco local (user, password, port, dbname, etc.). Clique no botão `ping` para testar a conexão.
- Na aba `JDBC Resources` adicione um novo `JDBC Resource` com o nome *JNDI* **jdbc/web**. O pool deve ser o que foi criado no passo anterior. **jdbc/web** é o nome do *datasource JTA* definido no *persistence.xml* do projeto: `<jta-data-source>jdbc/web</jta-data-source>`.

## Projeto
- Clone o projeto [https://github.com/Igor-Carvalho/javaee-login.git](https://github.com/Igor-Carvalho/javaee-login.git)
- Abra o projeto no *Netbeans*. É um projeto *maven* que o *Netbeans* deve detectar automaticamente (o *Netbeans* possui uma versão do *Maven* pré-instalada). Se for o caso, baixe um *Maven* mais recente e adicione ao *Netbeans* no menu `ferramentas>opções>java>maven`
- Clique com botão direito do mouse no projeto e escolha `construir com dependências`. Execute o projeto e selecione o servidor *payara* configurado anteriormente.
- Ao iniciar a aplicação alguns usuários são adicionados automaticamente no db:

```/**
 * EJB para inicialização de usuários no db para testes.
 * 
 * @author igor
 */
@Singleton
@Startup
public class InitDBEJB {

    @PersistenceContext
    private EntityManager em;

    /**
     * Insere usuários no banco de dados.
     *
     */
    @PostConstruct
    public void inicializarUsuários() {
        long total = Long.parseLong(em.createQuery("select count(u) from usuário u").getSingleResult().toString());
        if (total == 0) {
            em.persist(new Usuário("user", "password"));
            em.persist(new Usuário("igor", "igor123"));
            em.persist(new Usuário("natan", "natan123"));
        }
    }
}```
