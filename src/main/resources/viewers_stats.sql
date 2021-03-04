/*
There is the table schema below that stores "view" events from users from different regions.
Need to write query to show 5 regions with biggest number of unique "views" for the last month sorted by these numbers descending.
It is possible to update schema to speed up query.
*/

create table viewers_stats
(
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    account_id  BIGINT        NOT NULL,
    region      VARCHAR(256)  NOT NULL,
    created     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(id)
);

-- query to show 5 regions with biggest number of unique "views" for the last month sorted by these numbers descending.
select region from viewers_stats
where created >= DATE_FORMAT(CURRENT_DATE, '%Y-%m-01')
group by region
order by count(id) desc
limit 5;

--to speed up the query - an index on the 'created' field can be created